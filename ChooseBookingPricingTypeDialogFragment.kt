package com.vrsidekick.dialogFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vrsidekick.R
import com.vrsidekick.databinding.FragmentChooseBookingPricingTypeDialogBinding
import com.vrsidekick.utils.PricingType
import com.vrsidekick.utils.setSafeOnClickListener

private const val TAG ="ChooseBookingPricingTypeDialogFragment"



class ChooseBookingPricingTypeDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentChooseBookingPricingTypeDialogBinding
    private var mCallback : IChoosePricingType? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseBookingPricingTypeDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener() {

        binding.btSelectContinue.setSafeOnClickListener {
            when(binding.rgPricingType.checkedRadioButtonId){
                binding.rbHourly.id -> mCallback?.onPricingTypeSelect(PricingType.HOURLY)
                binding.rbMonthly.id -> mCallback?.onPricingTypeSelect(PricingType.MONTHLY)
            }
            dismiss()
        }

    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ChooseBookingPricingTypeDialogFragment()

    }


    fun setOnChoosePricingTypeListener(callback : IChoosePricingType){
        mCallback = callback
    }


    interface IChoosePricingType{
        fun onPricingTypeSelect(pricingType : PricingType)
    }
}