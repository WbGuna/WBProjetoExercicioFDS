package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDAO;
import entidades.Carro;
import entidades.Ipva;


@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarroDAO dao;
    private Ipva resultado;

   
    public ServletCarro() {
        super();
        dao = new CarroDAO();
        resultado = new Ipva(0);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String modelo = request.getParameter("modelo");
		String cor = request.getParameter("cor");
		String ano = request.getParameter("ano");
		
		String option = request.getParameter("option");
		
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			if ((modelo != null) && (cor!= null) && (ano!= null)) {
				if (!modelo.equals("")){
					 dao = new CarroDAO();
					 Carro carro = new Carro(modelo, cor, Integer.parseInt(ano));
					 dao.addCarro(carro);
				}
			}
			
		}				
		request.setAttribute("lista", dao.getListCarro());
		request.setAttribute("resultado", resultado.retornaAno());
		request.setAttribute("comIpva", resultado.ComIpva());
		request.setAttribute("semIpva", resultado.SemIpva());
		request.setAttribute("quantidade", dao.Quantidade());
		
		request.getRequestDispatcher("carro.jsp").forward(request, response);			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("formularioCarro.jsp").forward(request, response);		
	}
	
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Carro userBuscar=  dao.buscarCarro(id1);
		request.setAttribute("user", userBuscar);
		request.getRequestDispatcher("formularioCarro.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String modelo = request.getParameter("modelo");
		String cor = request.getParameter("cor");
		String ano = request.getParameter("ano");
		
		
		
		if ((modelo != null) && (cor != null) && (ano != null)) {
			if (!modelo.equals("")){
				dao = new CarroDAO();
				Integer id1 = Integer.parseInt(id);
				Carro carro1 = new Carro(modelo, cor,  Integer.parseInt(ano));
				carro1.setId(id1);
				dao.updateCarro(carro1);		
			}
		} 		
	}
	
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new CarroDAO();
			dao.removeCarro(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		String cor = request.getParameter("cor");
		String ano = request.getParameter("ano");
		
		if ((modelo != null) && (cor!= null) && (ano!= null)) {
			if (!modelo.equals("")){
				 dao = new CarroDAO();
				 Carro carro = new Carro(modelo, cor, Integer.parseInt(ano));
				 dao.addCarro(carro);
			}
		}	
	}
	
}