package uz.kozimjon.calctask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import io.paperdb.Paper
import uz.kozimjon.calctask.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Paper.init(this)

        val actions: String? = Paper.book().read("actions")
        val result: String? = Paper.book().read("result")
        if (!actions.isNullOrEmpty() && !result.isNullOrEmpty()) {
            binding.tvActions.text = actions
            binding.tvResult.text = result
        }

        binding.switchMaterial.setOnCheckedChangeListener { _, isChecked ->
            Paper.book().write("actions", binding.tvActions.text.toString())
            Paper.book().write("result", binding.tvResult.text.toString())

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
            var result = Calc.calc(binding.tvActions.text.toString()).toString()

            if (result.reversed()[0] == '0' && result.reversed()[1] == '.') {
                result = result.toDouble().roundToInt().toString()
            }

            binding.tvResult.text = stringFromJNI(result)
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