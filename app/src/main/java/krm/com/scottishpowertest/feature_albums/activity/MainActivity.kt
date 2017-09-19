package krm.com.scottishpowertest.feature_albums.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.feature_albums.fragment.ImageGridListFragment
import krm.com.scottishpowertest.feature_albums.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ImageGridListFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
