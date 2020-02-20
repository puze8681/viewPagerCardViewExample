package kr.puze.customcardview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageList: ArrayList<String> = ArrayList()
        var nameList: ArrayList<String> = ArrayList()
        imageList.add("https://image.shutterstock.com/image-photo/bright-spring-view-cameo-island-260nw-1048185397.jpg")
        imageList.add("https://image.shutterstock.com/image-photo/bright-spring-view-cameo-island-260nw-1048185397.jpg")
        imageList.add("https://image.shutterstock.com/image-photo/bright-spring-view-cameo-island-260nw-1048185397.jpg")
        nameList.add("좋은 경치1")
        nameList.add("좋은 경치2")
        nameList.add("좋은 경치3")

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val pagerAdapter = CardFragmentPagerAdapter(supportFragmentManager)
        for (i in 0 until nameList.size) {
            Log.d("MainLog", "addCardFragment : $i")
            pagerAdapter.addCardFragment(CardFragment(), imageList[i], nameList[i])
        }
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 3
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                //여기에 dot indicator 넣어야함
            }

            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })

        tab_layout.setupWithViewPager(viewPager, true)
    }
}
