package xyz.chriskalos.tunestimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.chriskalos.tunestimer.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_timer)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AlarmPicker::class.java).apply {}
            startActivity(intent)
        }

        binding.cardView1.setOnClickListener {
            val intent = Intent(this, ShowerTimer::class.java).apply {}
            startActivity(intent)
        }
    }
}