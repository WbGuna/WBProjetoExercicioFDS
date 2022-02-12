package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IpvaDAO;
import entidades.Ipva;


@WebServlet("/ServletIpva")
public class ServletIpva extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IpvaDAO dao;
   
    public ServletIpva() {
        super();
        dao = new IpvaDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String id = request.getParameter("id");
		String ano = request.getParameter("ano");
		
		String option = request.getParameter("option");
		
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
				
		} else if (option.equals("insert")) {
			if ((ano != null)) {
				if (!ano.equals("")){
					 dao = new IpvaDAO();
					 Ipva ipva = new Ipva(Integer.parseInt(ano));
					 dao.addIpva(ipva);
				}
			}
			
		}				
		request.setAttribute("lista", dao.getListIpva());
		
		request.getRequestDispatcher("ipva.jsp").forward(request, response);			
	}
	
	protected void Listagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista", dao.getListIpva());
		request.getRequestDispatcher("ipva.jsp").forward(request, response);			
	}
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("formularioIpva.jsp").forward(request, response);		
	}
	

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Ipva Buscar = dao.buscarIpva(id1);
		request.setAttribute("user", Buscar);
		request.getRequestDispatcher("formularioIpva.jsp").forward(request, response);		
	}
	
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ano = request.getParameter("ano");

	
		if ((ano!= null)) {
			if (!ano.equals("")){
				dao = new IpvaDAO();
				Integer id1 = Integer.parseInt(id);
				Ipva ipva1 = new Ipva(Integer.parseInt(ano));
				ipva1.setId(id1);
				dao.updateIpva(ipva1);		
			}
		} 		
	}

	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ano = request.getParameter("ano");
		
		if ((ano!= null)) {
			if (!ano.equals("")){
				 dao = new IpvaDAO();
				 Ipva ipva = new Ipva(Integer.parseInt(ano));
				 dao.addIpva(ipva);
			}
		}	
	}
	
}
