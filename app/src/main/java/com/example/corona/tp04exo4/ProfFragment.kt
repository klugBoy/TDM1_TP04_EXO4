package com.example.corona.tp04exo4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.corona.tp04exo4.Data.Module
import com.example.corona.tp04exo4.Data.Prof
import kotlinx.android.synthetic.main.fragment_module.*
import kotlinx.android.synthetic.main.fragment_prof.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfFragment : Fragment() {

    var prof :Prof? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_prof, container, false)
        // Inflate the layout for this fragment
        val b : Bundle? = arguments
        prof = b?.get("prof") as Prof
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nomProf.setText(prof?.nomProf)
        prenomProf.setText(prof?.prenomProf)
        ageProf.setText(prof?.ageProf)
        sexeProf.setText(prof?.sexeProf)
    }


}
