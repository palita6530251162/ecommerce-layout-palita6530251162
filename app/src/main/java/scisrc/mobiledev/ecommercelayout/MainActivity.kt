package scisrc.mobiledev.ecommercelayout

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import scisrc.mobiledev.ecommercelayout.databinding.ActivityMainBinding
import scisrc.mobiledev.ecommercelayout.ui.HomeFragment
import scisrc.mobiledev.ecommercelayout.ui.cart
import scisrc.mobiledev.ecommercelayout.ui.detail
import scisrc.mobiledev.ecommercelayout.ui.favorites
import scisrc.mobiledev.ecommercelayout.ui.products
import scisrc.mobiledev.ecommercelayout.ui.profile

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)

        // Initialize navigation
        drawerLayout = binding.drawerLayout

        // Add hamburger icon
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle NavigationView item clicks
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                }

                R.id.nav_products -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, products())
                        .commit()
                }

                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, cart())
                        .commit()
                }

                R.id.nav_favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, favorites())
                        .commit()
                }

                R.id.nav_profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, profile())
                    .commit()
                }

                R.id.textView6 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, detail())
                        .commit()
                }

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Load default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
