package gb.spring.lesson4.service;

import gb.spring.lesson4.model.MyString;
import gb.spring.lesson4.model.PersonEntity;
import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.model.ProductEntity;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@NoArgsConstructor
public class CrudService {
    private static SessionFactory factory;

    public static void forcePrepareData() {
        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void init() {
        forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static List<ProductEntity> showManyItems() {
        List<ProductEntity> items;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            items = session.createQuery("from ProductEntity ").getResultList();
            System.out.println(items + "\n");
            session.getTransaction().commit();
        }
        return items;
    }

    public static void shutdown() {
        factory.close();
    }

    public static List<ProductEntity> findAll() {
        List<ProductEntity> items = null;
        try {
            init();
            items = showManyItems();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return items;
    }

    public static List<ProductEntity> findByDescription(String description){
        List<ProductEntity> products;
        init();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            products = session.createQuery("from ProductEntity where description = "+"'" + description + "'").getResultList();
            System.out.println("+++++++++: select p from ProductEntity p where p.description = " + description + "\n");
            session.getTransaction().commit();
        }finally {
            shutdown();
        }
        return products;
    }

    public static List<ProductEntity> findByCompany(String company) {
        List<ProductEntity> companies;
        init();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            companies = session.createQuery("from ProductEntity where company = "+"'" + company + "'").getResultList();
            System.out.println("+++++++++: from ProductEntity where company = "+"'" + company + "'" + "\n");
            session.getTransaction().commit();
        }finally {
            shutdown();
        }
        return companies;
    }

    public List<PersonEntity> findByPersonName(MyString PersonName) {
        String findPersonName = PersonName.getDescription();
        List<PersonEntity> persons;
        init();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            persons = session.createQuery("from PersonEntity where name = "+"'" + findPersonName + "'").getResultList();
            System.out.println("+++++++++: from ProductEntity where company = "+"'" + findPersonName + "'" + "\n");
            session.getTransaction().commit();
        }finally {
            shutdown();
        }
        return persons;
    }

    public static List<ProductEntity> findByCoast(String coast) {
        List<ProductEntity> products;
        init();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("from ProductEntity where coast "+ coast).getResultList();
            System.out.println("+++++++++: from ProductEntity where coast "+"'" + coast + "'"+ "\n");
            session.getTransaction().commit();
        }finally {
            shutdown();
        }
        return products;
    }

    public List<String> getCompanies() {
        List<String> companies;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            companies = session.createQuery("select company from ProductEntity").getResultList();
            System.out.println("+++++++++++"+companies+"\n");
            session.getTransaction().commit();
        }finally {
            shutdown();
        }
        return companies;
    }
}
