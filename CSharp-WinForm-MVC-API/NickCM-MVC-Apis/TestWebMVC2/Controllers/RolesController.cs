using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace TestWebMVC2.Controllers
{
    public class RolesController : Controller
    {
        private string AdminRole = "Administrators";
        private string UserEmail = "test@example.com";
        private readonly RoleManager<IdentityRole> roleManager;
        private readonly UserManager<IdentityUser> userManager;

        public RolesController(RoleManager<IdentityRole> roleManager, UserManager<IdentityUser> userManager)
        {
            this.roleManager = roleManager;
            this.userManager = userManager;
        }

        [ResponseCache(Duration = 10, Location = ResponseCacheLocation.Any)]
        public async Task<IActionResult> Index()
        {
            if (!(await roleManager.RoleExistsAsync(AdminRole)))
            {
                await roleManager.CreateAsync(new IdentityRole(AdminRole));
            }
            IdentityUser user = await userManager.FindByEmailAsync(UserEmail);

            if (user == null)
            {
                //make a new user
                user = new();
                user.Email = UserEmail;
                user.UserName = UserEmail;
                IdentityResult result = await userManager.CreateAsync(user, "Pa$$w0rd");
                if (result.Succeeded)
                {
                    Console.WriteLine($"User {user.UserName} created successfully!");

                }
                else
                {
                    foreach (IdentityError error in result.Errors)
                    {
                        Console.WriteLine(error.Description);
                    }
                }
            }
            if (!user.EmailConfirmed)
            {
                string token = await userManager.GenerateEmailConfirmationTokenAsync(user);
                IdentityResult result = await userManager.ConfirmEmailAsync(user, token);

                if (result.Succeeded)
                {
                    Console.WriteLine($"User {user.UserName} email confirmed successfully.");
                }
                else
                {
                    foreach (IdentityError error in result.Errors)
                    {
                        Console.WriteLine(error.Description);
                    }
                }

            }
            if (!(await userManager.IsInRoleAsync(user, AdminRole)))
            {
                IdentityResult result = await userManager.AddToRoleAsync(user, AdminRole);
                if (result.Succeeded)
                {
                    Console.WriteLine($"User {user.UserName} added to {AdminRole} successfully.");
                }
                else
                {
                    foreach (IdentityError error in result.Errors)
                    {
                        Console.WriteLine(error.Description);
                    }
                }
            }
            return Redirect("/");//redirect to home page

        }
    }
}
