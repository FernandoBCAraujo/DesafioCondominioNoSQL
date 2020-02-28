package com.br.uati.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.uati.dto.ProprietarioDTO;
import com.br.uati.enums.StatusAlugado;
import com.br.uati.enums.StatusPagamentoDespesa;
import com.br.uati.models.Apartamento;
import com.br.uati.models.Despesa;
import com.br.uati.models.Proprietario;
import com.br.uati.repositories.ApartamentoRepository;
import com.br.uati.repositories.DespesaRepository;
import com.br.uati.repositories.ProprietarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	@Autowired
	private DespesaRepository despesaRepository;
	
	@Override
	public void run(String... args) throws Exception {

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		proprietarioRepository.deleteAll();
		apartamentoRepository.deleteAll();
		despesaRepository.deleteAll();

		Proprietario proprietario = new Proprietario(null, "Fernando Bezerra", "37487129459", "349381837",
				"fernando@email.com");
		Proprietario proprietario2 = new Proprietario(null, "Gessika Maria", "12345678909", "983713837",
				"gessika@email.com");
		Proprietario proprietario3 = new Proprietario(null, "Tuca Andrade", "854573112893", "30393837",
				"tuca@email.com");

		proprietarioRepository.saveAll(Arrays.asList(proprietario, proprietario2, proprietario3));

		Apartamento apartamento = new Apartamento(null, "707", new ProprietarioDTO(proprietario),
				StatusAlugado.ALUGADO);
		Apartamento apartamento4 = new Apartamento(null, "107", new ProprietarioDTO(proprietario),
				StatusAlugado.DESALUGADO);
		Apartamento apartamento2 = new Apartamento(null, "777", new ProprietarioDTO(proprietario2),
				StatusAlugado.ALUGADO);
		Apartamento apartamento3 = new Apartamento(null, "717", new ProprietarioDTO(proprietario3),
				StatusAlugado.ALUGADO);

		apartamentoRepository.saveAll(Arrays.asList(apartamento, apartamento2, apartamento3, apartamento4));

		Despesa despesa = new Despesa(null, new ProprietarioDTO(proprietario), "Conta de Energia", new BigDecimal(280),
				LocalDate.now(), LocalDate.of(2020, 03, 28), StatusPagamentoDespesa.AGUARDANDO_PAGAMENTO,
				"tipoDespesa");
		Despesa despesa2 = new Despesa(null, new ProprietarioDTO(proprietario2), "Conta de Energia", new BigDecimal(280),
				LocalDate.now(), LocalDate.of(2020, 03, 28), StatusPagamentoDespesa.AGUARDANDO_PAGAMENTO,
				"tipoDespesa");
		Despesa despesa3 = new Despesa(null, new ProprietarioDTO(proprietario3), "Conta de Energia", new BigDecimal(280),
				LocalDate.now(), LocalDate.of(2020, 03, 28), StatusPagamentoDespesa.AGUARDANDO_PAGAMENTO,
				"tipoDespesa");
		
		despesaRepository.saveAll(Arrays.asList(despesa, despesa2, despesa3));

		proprietario.getApartamentos().addAll(Arrays.asList(apartamento, apartamento4));
		proprietario2.getApartamentos().addAll(Arrays.asList(apartamento2));
		proprietario3.getApartamentos().addAll(Arrays.asList(apartamento3));
		
		proprietario.getDespesas().addAll(Arrays.asList(despesa));
		proprietario2.getDespesas().addAll(Arrays.asList(despesa2));
		proprietario3.getDespesas().addAll(Arrays.asList(despesa3));

		proprietarioRepository.save(proprietario);
		proprietarioRepository.save(proprietario2);
		proprietarioRepository.save(proprietario3);

	}

}
