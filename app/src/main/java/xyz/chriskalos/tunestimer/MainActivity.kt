package xyz.chriskalos.tunestimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.chriskalos.tunestimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Timer.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java).apply {}
            startActivity(intent)
        }
        binding.Pools.setOnClickListener {
            val intent = Intent(this, PoolsActivity::class.java).apply {}
            startActivity(intent)
        }
        binding.Settings.setOnClickListener {
//            val toast = Toast.makeText(applicationContext, "Timer!", Toast.LENGTH_SHORT);
//            toast.show();
            val intent = Intent(this, SettingsActivity::class.java).apply {}
            startActivity(intent)
        }
        binding.Feedback.setOnClickListener {
            val intent = Intent(this, FeedbackActivity::class.java).apply {}
            startActivity(intent)
        }
    }
}