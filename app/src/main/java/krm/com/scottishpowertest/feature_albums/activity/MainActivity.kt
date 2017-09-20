package krm.com.scottishpowertest.feature_albums.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.feature_albums.fragment.AlbumListFragment
import krm.com.scottishpowertest.feature_albums.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = AlbumListFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(AlbumListFragment::class.java.name)
        fragmentTransaction.commit()

        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onSupportNavigateUp()
        onBackPressed()
        return true
    }
}
