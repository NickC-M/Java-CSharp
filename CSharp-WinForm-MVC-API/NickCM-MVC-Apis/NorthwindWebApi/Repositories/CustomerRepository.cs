using Cpt206.SqlServer; // customer
using Microsoft.EntityFrameworkCore.ChangeTracking; //entity entry
using System.Collections.Concurrent;
using System.Reflection.Metadata.Ecma335; //concurrent dictionary


namespace NorthwindWebApi.Repositories
{
    public class CustomerRepository : ICustomerRepository
    {
        //create a cache to store the customers
        //dictionary
        private static ConcurrentDictionary<string, Customer>? customerCache;

        private NorthwindContext db;

        public CustomerRepository(NorthwindContext _db)
        {
            db = _db;

            //init our cache

            if (customerCache == null)
            {
                //we are going to fill the cache with the database info
                customerCache = new ConcurrentDictionary<string, Customer>(db.Customers.ToDictionary(c => c.CustomerId));
            }
        }


        //a web api is an online database
        public async Task<Customer?> CreateAsync(Customer c)
        {
            //normalizing the ID
            c.CustomerId = c.CustomerId.ToUpper();
            //add this to db
            EntityEntry<Customer> added = await db.Customers.AddAsync(c);
            //affected is the number of rows changed
            int affected = await db.SaveChangesAsync();
            if (affected == 1)
            {
                //we added a customer to db
                if (customerCache is null)
                {
                    return c;
                }
                //if the cache is not null we want to update the cache
                return customerCache.AddOrUpdate(c.CustomerId, c, UpdateCache);
            }
            //we were unable to add user
            else return null;
        }

        //retrieve all info from the cache instead of the database
        public Task<IEnumerable<Customer>> RetrieveAllAsync()
        {
            return Task.FromResult(customerCache is null ? Enumerable.Empty<Customer>() : customerCache.Values);
        }


        public Task<Customer?> RetrieveAsync(string id)
        {
            //search for the id
            id = id.ToUpper();
            if(customerCache is null)
            {
                return null;
            }
            customerCache.TryGetValue(id, out Customer? customer);

            return Task.FromResult(customer);
        }


        private Customer UpdateCache(string id, Customer customer)
        {
            Customer? old;
            if (customerCache is not null)
            {
                if (customerCache.TryGetValue(id, out old)){
                    if(customerCache.TryUpdate(id, customer, old)){
                        return customer;
                    }
                }
            }
            return null;
        }


        public async Task<Customer?> UpdateAsync(string id, Customer customer)
        {
            //normaalize ids
            id = id.ToUpper();
            customer.CustomerId = customer.CustomerId.ToUpper();

            //update the database
            db.Customers.Update(customer);
            int affected = await db.SaveChangesAsync();
            if(affected== 1)
            {
                return UpdateCache(id, customer);
            }
            return null;
        }


        //delete
        public async Task<bool?>DeleteAsync(string id)
        {
            id=id.ToUpper();
            Customer? customer = db.Customers.Find(id);
            if(customer is null)
            {
                return false;
            }
            db.Customers.Remove(customer); //remove the customer from the database
            int affected = await db.SaveChangesAsync();
            if(affected == 1)
            {
                //one row deleted
                if(customer is null)
                {
                    return false;
                }

                return customerCache.TryRemove(id, out customer);
            }
            else
            {
                return false;
            }


        }


    }
}
