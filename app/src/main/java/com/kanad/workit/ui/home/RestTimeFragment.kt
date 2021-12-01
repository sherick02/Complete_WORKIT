package com.kanad.workit.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kanad.workit.MainActivity
import com.kanad.workit.R
import com.kanad.workit.data.model.ExerciseModel
import com.kanad.workit.databinding.FragmentRestTimeBinding
import com.kanad.workit.ui.base.BaseFragment
import com.kanad.workit.utils.ParamArgus
import com.kanad.workit.utils.SimpleCountDownTimer
import com.kanad.workit.utils.SimpleCountDownTimer.OnCountDownListener

/**
 * A simple [Fragment] subclass.
 * Use the [RestTimeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestTimeFragment : BaseFragment(), View.OnClickListener {

    private val mParam1: String? = null
    private var binding: FragmentRestTimeBinding? = null
    private var exerciseModel: ExerciseModel? = null
    var simpleCountDownTimer: SimpleCountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            exerciseModel = requireArguments()!!.getSerializable(ParamArgus.MODEL) as ExerciseModel?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestTimeBinding.inflate(inflater, container, false)
        val root = binding!!.root
        initViews()
        setListeners()
        return root
    }

    override fun initViews() {
        if (exerciseModel != null) {
            //binding.tvRestTime.setText("" + exerciseModel.getRest_time());
            simpleCountDownTimer = SimpleCountDownTimer(
                0,
                exerciseModel!!.rest_time.toLong(),
                1,
                object : OnCountDownListener {
                    override fun onCountDownActive(time: String?) {
                        binding!!.tvRestTime.text = "" + time
                    }

                    override fun onCountDownFinished() {
                        if (isAdded && isVisible && userVisibleHint) {
                            (requireActivity() as MainActivity).onDoBack()
                        }
                    }
                })
            simpleCountDownTimer!!.start(false)


        }
    }

    override fun setListeners() {}
    override val actContext: Context
        protected get() = requireContext()
    override val fragmentContext: Fragment
        protected get() = this

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_done -> {
            }
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment HomeFragment.
         */
        fun newInstance(param1: String?, param2: String?): RestTimeFragment {
            val fragment = RestTimeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}