using NorthwindWebApi.Repositories;
using Microsoft.AspNetCore.Mvc;
using Cpt206.SqlServer;
namespace NorthwindWebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CustomersController : ControllerBase
    {


        private readonly ICustomerRepository repo;

        public CustomersController(ICustomerRepository repo)
        {
            this.repo = repo;
        }

        [HttpGet]
        [ProducesResponseType(200, Type = typeof(IEnumerable<Customer>))]
        public async Task<IEnumerable<Customer>> GetCustomers(string? country)
        {
            //return all customers
            if (string.IsNullOrEmpty(country))
            {
                return await repo.RetrieveAllAsync();
            }
            else
            {
                return (await repo.RetrieveAllAsync()).Where(customer => customer.Country == country);

            }
        }

        // GET: api/customers/[id]
        [HttpGet("{id}", Name = nameof(GetCustomer))] // named route
        [ProducesResponseType(200, Type = typeof(Customer))]
        [ProducesResponseType(404)]
               public async Task<IActionResult> GetCustomer(string id)
        {
            Customer? c = await repo.RetrieveAsync(id);
            if (c == null)
            {
                return NotFound();
            }
            return Ok(c);

        }


        // POST: api/customers
        // BODY: Customer (JSON, XML)
        [HttpPost]
        [ProducesResponseType(201, Type = typeof(Customer))]
        [ProducesResponseType(400)]
        public async Task<IActionResult> Create([FromBody] Customer customer)
        {
            if (customer==null)
            {
                return BadRequest();   
            }

            Customer? addedCustomer = await repo.CreateAsync(customer);

            if (addedCustomer == null)
            {
                return BadRequest("Repository failed to create customer.");

            }
            else
            {
                return CreatedAtRoute(routeName: nameof(GetCustomer), routeValues: new { id = addedCustomer.CustomerId.ToLower() }, value: addedCustomer);
            }
        }

        // PUT: api/customers/[id]
        // BODY: Customer (JSON, XML)
        [HttpPut("{id}")]
        [ProducesResponseType(204)]
        [ProducesResponseType(400)]
        [ProducesResponseType(404)]
        public async Task<IActionResult> Update(string id, [FromBody] Customer customer)
        {
            id = id.ToUpper();
            customer.CustomerId = customer.CustomerId.ToUpper();

            if (customer == null || customer.CustomerId != id)
            {
                return BadRequest();
            }

            Customer? existing = await repo.RetrieveAsync(id);

            if (existing == null)
            {
                return NotFound();
            }

            await repo.UpdateAsync(id, customer);
            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        [ProducesResponseType(204)]
        [ProducesResponseType(400)]
        [ProducesResponseType(404)]
        public async Task<IActionResult> Delete(string id)
        {
            Customer? existing = await repo.RetrieveAsync(id);
            if(existing == null)
            {
                return NotFound();
            }
            bool? deleted = await repo.DeleteAsync(id);

            if(deleted.HasValue && deleted.Value)
            {
                return new NoContentResult();
            }
            else
            {
                return BadRequest($"Customer {id} was found but failed to delete.");
            }

        }





    }
}
