package tw.edu.pu.csim.tcyang.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewDebug
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    var Flog:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlideApp.with(this)
            .load(R.drawable.cover)

            .override(800, 600)

            .into(imageTitle)

        Toast.makeText(baseContext, "作者：謝純善", Toast.LENGTH_LONG).show()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        })
        imgNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                RndShape()

                }

         })
    }
    fun RndShape() {
        Flog = (1..4).random()
        when (Flog) {
            1 -> imgNext.setImageResource(R.drawable.circle)
            2 -> imgNext.setImageResource(R.drawable.star)
            3 -> imgNext.setImageResource(R.drawable.triangle)
            4 -> imgNext.setImageResource(R.drawable.square)
        }
    }
}