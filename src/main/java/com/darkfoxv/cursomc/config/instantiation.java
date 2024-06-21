package com.darkfoxv.cursomc.config;

import com.darkfoxv.cursomc.domain.*;
import com.darkfoxv.cursomc.domain.enums.EstadoPagamento;
import com.darkfoxv.cursomc.domain.enums.TipoCliente;
import com.darkfoxv.cursomc.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;


    @Override
    public void run(String... args) throws ParseException {
        Categoria cat1 = new Categoria(1L, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.0);
        Produto p2 = new Produto(null, "Impressora", 800.0);
        Produto p3 = new Produto(null, "Mouse", 80.0);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "São Paulo");
        Estado est2 = new Estado(null, "Minas Gerais");
        estadoRepository.saveAll(Arrays.asList(est1, est2));

        Cidade c1 = new Cidade(null, "São Paulo", est1);
        Cidade c2 = new Cidade(null, "Uberlândia", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "362379967823", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", c1, cli1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "238690", c1, cli1);
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2 );
        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);
        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

    }
}
