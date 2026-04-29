using Azure;
using Cpt206.SqlServer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Northwind.Common;
using System.Data.Common;
using System.Diagnostics;
using TestWebMVC2.Models;
namespace TestWebMVC2.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly NorthwindContext db;
        private readonly IHttpClientFactory clientFactory;



        public HomeController(ILogger<HomeController> logger, NorthwindContext _db, IHttpClientFactory httpClientFactory)
        {
            _logger = logger;
            db = _db; //this is our database
            clientFactory = httpClientFactory;
        }


        public async Task<IActionResult> Customers(string country)
        {
            string uri;
            if (string.IsNullOrEmpty(country))
            {
                ViewData["Title"] = "All Customers Worldwide";
                uri = "api/customers/";
            }
            else
            {
                ViewData["Title"] = $"Customers in {country}";
                uri = $"api/customers/?country={country}";
            }
            HttpClient client = clientFactory.CreateClient(
            name: "NorthwindWebApi");
            HttpRequestMessage request = new(
            method: HttpMethod.Get, requestUri: uri);
            HttpResponseMessage response = await client.SendAsync(request);
            IEnumerable<Customer>? model = await response.Content
            .ReadFromJsonAsync<IEnumerable<Customer>>();
            return View(model);
        }

        public async Task<IActionResult> Index()
        {
            _logger.LogError("This is an error but not serious");
            _logger.LogWarning("Warning, this is a warning");
            _logger.LogInformation("I am in the index method");


            HomeIndexViewModel model = new
                (
                    VisitorCount: (new Random()).Next(1, 1001),
                    Categories: await db.Categories.ToListAsync(),
                    Products: await db.Products.ToListAsync()
                );

            try
            {
                HttpClient client = clientFactory.CreateClient(name: "Minimal.WebApi");
                HttpRequestMessage request = new(method: HttpMethod.Get, requestUri: "api/weather");
                HttpResponseMessage response = await client.SendAsync(request);
                ViewData["weather"] = await response.Content.ReadFromJsonAsync<WeatherForecast[]>();
            }
            catch (Exception ex)
            {
                _logger.LogWarning($"The Minimal.WebApi service is not responding. Exception: {ex.Message}");
                ViewData["weather"] = Enumerable.Empty<WeatherForecast>().ToArray();
            }

            return View(model);

        }

  
        [Authorize(Roles = "Administrators")]



        public IActionResult Privacy()
        {
            return View();
        }

        public IActionResult ProductDetail(int? id)
        {
            if (!id.HasValue)
            {
                return BadRequest("You must pass a product ID in the route, for example, /Home/ProductDetail/21");
            }
            Product? model = db.Products
            .SingleOrDefault(p => p.ProductId == id);
            if (model == null)
            {
                return NotFound($"ProductId {id} not found.");
            }
            return View(model); // pass model to view and then return result
        }
        [HttpGet]
        public IActionResult ModelBinding()
        {
            return View();
        }
        [HttpPost]
        public IActionResult ModelBinding(Thing thing)
        {
            return View(thing);
        }

        public IActionResult ProductsThatCostMoreThan(decimal? price)
        {
            if(!price.HasValue)
            {
                return BadRequest("You must pass a product price in the query string for example, /Home/ProductsThatCostMoreThan?price=50");
            }
            IEnumerable<Product> model = db.Products
            .Include(p => p.Category)
            .Include(p => p.Supplier)
            .Where(p => p.UnitPrice > price);
            if (!model.Any())
            {
                return NotFound(
                $"No products cost more than {price:C}.");
            }
            ViewData["MaxPrice"] = price.Value.ToString("C");
            return View(model); // pass model to view
        }


        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
