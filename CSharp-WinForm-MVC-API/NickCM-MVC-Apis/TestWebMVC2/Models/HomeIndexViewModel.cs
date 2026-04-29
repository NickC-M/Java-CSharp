using Cpt206.SqlServer;

namespace TestWebMVC2.Models
{
    public record HomeIndexViewModel(

     int VisitorCount,

     IList<Category> Categories,

     IList<Product> Products

    );
}
