package academy.mindswap.services;

import academy.mindswap.persistence.Student;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StudentService {

    private EntityManagerFactory emf;

    public StudentService() {
        emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public void printStudentById(Integer id){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Student student = em.find(Student.class, id);
            System.out.println(student);

        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void printAllStudents(){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            CriteriaQuery<Student> query = em.getCriteriaBuilder().createQuery(Student.class);
            query.select(query.from(Student.class));
            List<Student> students = em.createQuery(query).getResultList();
            System.out.println(students);

            Query query2 = em.createQuery("SELECT s.name FROM Student s");
            List students2 = query2.getResultList();
            System.out.println(students2);

            TypedQuery<Student> query3 = em.createQuery("SELECT student FROM Student student", Student.class);
            List<Student> students3 = query3.getResultList();
            System.out.println(students3);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void createOrUpdateStudent(Integer id, String name, Integer edition){
        Student student = new Student(id, name, edition);
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }catch (RollbackException e){
            if(em!=null) {
                em.getTransaction().rollback();
            }
        }finally{
            if(em!=null){
                em.close();
            }
        }
    }
}
