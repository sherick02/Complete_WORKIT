package com.kanad.workit.ui.reminder

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kanad.workit.MainActivity
import com.kanad.workit.R
import com.kanad.workit.data.listeners.OnItemClickListener
import com.kanad.workit.data.model.RepeatModel
import com.kanad.workit.databinding.FragmentRepeatBinding
import com.kanad.workit.ui.adapters.RepeatAdapter
import com.kanad.workit.ui.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [RepeatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RepeatFragment : BaseFragment(), View.OnClickListener {

    private var mParam1: String? = null
    private var binding: FragmentRepeatBinding? = null
    var df = SimpleDateFormat("hh:mm a")

    private val repeat_days = arrayOf(
        "Every Sunday",
        "Every Monday",
        "Every Tuesday",
        "Every Wednesday",
        "Every Thursday",
        "Every Friday",
        "Every Saturday"
    )
    private val repeatModels = ArrayList<RepeatModel>()
    private var repeatAdapter: RepeatAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments()!!.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRepeatBinding.inflate(inflater, container, false)
        val root = binding!!.root
        initViews()
        setListeners()
        return root
    }

    override fun initViews() {
        for (i in 0..6) {
            val repeatModel = RepeatModel(repeat_days[i], false)
            repeatModels.add(repeatModel)
        }
        repeatAdapter =
            RepeatAdapter(repeatModels, requireActivity(), object : OnItemClickListener {
                override fun onItemClick(view: View?, position: Int) {}
                override fun onItemLongClick(view: View?, position: Int) {}
            })
        binding!!.rvRepeat.adapter = repeatAdapter
    }

    override fun setListeners() {
        binding!!.tvBack.setOnClickListener(this)
    }

    override val actContext: Context
        protected get() = requireContext()

    override val fragmentContext: Fragment
        protected get() = this

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_back -> (requireActivity() as MainActivity).onDoBack()
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
        fun newInstance(param1: String?, param2: String?): RepeatFragment {
            val fragment = RepeatFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}