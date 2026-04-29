using Cpt206.SqlServer;

namespace NorthwindWebApi.Repositories
{
    public interface ICustomerRepository
    {
        //Crud Operations for our Interface
        Task<Customer> CreateAsync(Customer c);

        Task<IEnumerable<Customer>> RetrieveAllAsync();
        Task<Customer?> RetrieveAsync(string id);
        Task<Customer> UpdateAsync(string id, Customer c);
        Task<bool?> DeleteAsync(string id);
    }
}
