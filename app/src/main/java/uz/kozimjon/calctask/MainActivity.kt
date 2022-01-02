package uz.kozimjon.calctask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import uz.kozimjon.calctask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchMaterial.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            } else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            }
        }

        binding.tvZero.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "0"
        }

        binding.tvOne.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "1"
        }

        binding.tvTwo.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "2"
        }

        binding.tvThree.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "3"
        }

        binding.tvFour.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "4"
        }

        binding.tvFive.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "5"
        }

        binding.tvSix.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "6"
        }

        binding.tvSeven.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "7"
        }

        binding.tvEight.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "8"
        }

        binding.tvNine.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "9"
        }

        binding.tvPlus.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "+"
        }

        binding.tvMinus.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "-"
        }

        binding.tvMultiple.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "*"
        }

        binding.tvDiv.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "/"
        }

        binding.tvDot.setOnClickListener {
            binding.tvActions.text = binding.tvActions.text.toString() + "."
        }

        binding.tvClear.setOnClickListener {
            binding.tvActions.text = ""
            binding.tvResult.text = "0"
        }

        binding.tvEqual.setOnClickListener {
            binding.tvResult.text = stringFromJNI(Calc.calc(binding.tvActions.text.toString()).toString())
        }

        binding.tvPercent.setOnClickListener {
            binding.tvResult.text = stringFromJNI((binding.tvResult.text.toString().toDouble() / 100.0).toString())
        }

        binding.tvDelete.setOnClickListener {
            if (binding.tvActions.text.toString().isNotEmpty()) {
                binding.tvActions.text = binding.tvActions.text.toString().reversed().substring(1).reversed()
            }
        }
    }

    private external fun stringFromJNI(result: String): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}