package xyz.chriskalos.tunestimer

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import xyz.chriskalos.tunestimer.databinding.ActivityShowerTimerBinding

private const val TAG = "TuneLog: "

class ShowerTimer : AppCompatActivity() {
    private lateinit var binding: ActivityShowerTimerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_shower_timer)
        binding = ActivityShowerTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var totalDuration: Long = 0
        val mediaPlayer = MediaPlayer.create(this, R.raw.timer)
//        val mediaPlayerDing1 = MediaPlayer.create(this, R.raw.ding)
//        val mediaPlayerDing2 = MediaPlayer.create(this, R.raw.ding)
//        val mediaPlayerDing3 = MediaPlayer.create(this, R.raw.ding)
        var tempDuration = mediaPlayer.duration
//        totalDuration += tempDuration*4
//        val mediaPlayer2 = MediaPlayer.create(this, R.raw.song1)
//        tempDuration = mediaPlayer2.duration
//        totalDuration += tempDuration
//        val mediaPlayer3 = MediaPlayer.create(this, R.raw.song2)
//        tempDuration = mediaPlayer3.duration
//        totalDuration += tempDuration
//        val mediaPlayer4 = MediaPlayer.create(this, R.raw.song3)
//        tempDuration = mediaPlayer4.duration
        totalDuration += tempDuration

        var totalSeconds= totalDuration / 1000
        var minutes = totalDuration / 1000 / 60
        var seconds = totalDuration / 1000 % 60
        var elaReGamwto: String = "$minutes minutes, $seconds seconds."
        binding.timerDurationView.text = elaReGamwto

        val timer = object: CountDownTimer(totalDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                totalSeconds--
                if(seconds>0) {
                    seconds--
                }
                else if (seconds <= 0 && minutes > 0){
                    seconds = 59
                    minutes--
                }
                elaReGamwto = "$minutes minutes, $seconds seconds"
                binding.timerDurationView.text = elaReGamwto
                var newProgress: Int = 100-((totalSeconds.toFloat()/(totalDuration.toFloat()/1000))*100).toInt()
                Log.d(TAG, "newProgress: $newProgress")
                Log.d(TAG, "totalSeconds: $totalSeconds")
                binding.progressBar.progress = newProgress
            }

            override fun onFinish() {
                mediaPlayer.stop()
                elaReGamwto = "Timer done!"
                binding.timerDurationView.text = elaReGamwto
            }
        }

        binding.playButton.setOnClickListener {
            mediaPlayer.start()
            timer.start()
        }
    }

}