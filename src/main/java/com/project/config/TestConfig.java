package com.project.config;

import com.project.entities.*;
import com.project.entities.enums.OrderStatus;
import com.project.entities.enums.PaymentStatus;
import com.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        // Categorias
        Category cat1 = new Category(null, "Eletrônicos");
        Category cat2 = new Category(null, "Livros");
        Category cat3 = new Category(null, "Computadores");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Produtos
        Product p1 = new Product(null, "O Senhor dos Anéis", "Livro de fantasia", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "TV 50 polegadas", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Notebook Apple", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Computador para jogos", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Livro de programação", 100.99, "");

        // Associando produtos às categorias
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Usuários
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        // Pedidos
        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Itens de pedido
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        // Pagamento
        Payment pay1 = new Payment(
            null,
            Instant.parse("2023-06-20T21:53:07Z"),
            PaymentStatus.PAID,
            "Cartão de Crédito",
            o1.getTotal(),
            o1
        );
        o1.setPayment(pay1);
        orderRepository.save(o1);
    }
}
