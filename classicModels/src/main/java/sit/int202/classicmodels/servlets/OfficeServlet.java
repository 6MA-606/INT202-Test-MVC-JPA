package sit.int202.classicmodels.servlets;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodels.models.Office;
import sit.int202.classicmodels.models.OfficeRepository;
import sit.int202.classicmodels.utils.EntityManagerBuilder;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OfficeListServlet", value = "/office")
public class OfficeServlet extends HttpServlet {
    private final OfficeRepository officeRepository = new OfficeRepository();
    private EntityManager em;
    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String officeCode = req.getParameter("officeCode");
        if (officeCode != null) {
            req.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }
        req.setAttribute("offices", officeRepository.findAll());
        req.getRequestDispatcher("office-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        if (req.getParameter("deleteCode") != null) {
            officeRepository.deleteByCode(req.getParameter("deleteCode"));
            System.out.println("Meow");
            resp.sendRedirect("office");
            return;
        }

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Office office = new Office();
        office.setOfficeCode(params.get("officeCode")[0]);
        office.setCity(params.get("city")[0]);
        office.setPhone(params.get("phone")[0]);
        office.setAddressLine1(params.get("addressLine1")[0]);
        office.setAddressLine2(params.get("addressLine2")[0]);
        office.setState(params.get("state")[0]);
        office.setCountry(params.get("country")[0]);
        office.setPostalCode(params.get("postalCode")[0]);
        office.setTerritory(params.get("territory")[0]);
        em.persist(office);

        em.getTransaction().commit();

        em.close();

        resp.sendRedirect("office");
    }
}
