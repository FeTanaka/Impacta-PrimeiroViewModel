package br.com.impacta.placarbasquete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import br.com.impacta.placarbasquete.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PrimeiroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val observadorA = Observer<Int> { placar -> binding.timeAPlacar.text = placar.toString() }

        viewModel.getScoreA().observe(viewLifecycleOwner, observadorA)

        viewModel.getScoreB().observe(viewLifecycleOwner) { placar ->
            binding.timeBPlacar.text = placar.toString()
        }

        binding.timeA3pontosBtn.setOnClickListener {
            viewModel.addPointsA(3)
        }

        binding.timeA2pontosBtn.setOnClickListener {
            viewModel.addPointsA(2)
        }

        binding.timeA1pontoBtn.setOnClickListener {
            viewModel.addPointsA(1)
        }

        binding.timeB3pontosBtn.setOnClickListener {
            viewModel.addPointsB(3)
        }

        binding.timeB2pontosBtn.setOnClickListener {
            viewModel.addPointsB(2)
        }

        binding.timeB1pontoBtn.setOnClickListener {
            viewModel.addPointsB(1)
        }

        binding.resetBtn.setOnClickListener {
            viewModel.resetScore()
        }
    }
}