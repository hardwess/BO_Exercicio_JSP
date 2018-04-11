package edu.curso.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.curso.dao.BODao;
import edu.curso.dao.BODaoImpl;
import edu.curso.entidades.BO;

@WebServlet("/BOController")
public class BOController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BOController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html><h1>Acesse a pagina <a href=\"./bos.jsp\">bos.jsp</a></h1></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId = request.getParameter("txtId");
		String txtNumero = request.getParameter("txtNumero");
		String txtNome = request.getParameter("txtNome");
		String txtRg = request.getParameter("txtRg");
		String txtTipo = request.getParameter("txtTipo");
		String txtData = request.getParameter("txtData");
		String txtLocal = request.getParameter("txtLocal");
		String txtDescricao = request.getParameter("txtDescricao");
		String txtCmd = request.getParameter("cmd");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<BO> lista = (List<BO>)getServletContext().getAttribute("LISTA");
		if (lista == null) {
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);
		}
		String message = null;
		BODao boDao = new BODaoImpl();
		
		if ("adicionar".equals(txtCmd)) {
			BO b = new BO();
			b.setId( Long.parseLong(txtId) );
			b.setNumero(txtNumero);
			b.setNome(txtNome);
			b.setRg(txtRg);
			b.setTipo(txtTipo);
			b.setDescricao(txtDescricao);
			b.setLocal(txtLocal);
			try {
				b.setDataOcorrencia( sdf.parse(txtData) );
			} catch (ParseException e) {
				e.printStackTrace();
			}
			boDao.adicionar( b );
			message = String.format("BO adicionado corretamente %s\n", b);
		} else if ("pesquisar".equals(txtCmd)) {
			lista = boDao.pesquisarPorNome(txtNome);
			request.getSession().setAttribute("LISTA", lista);
			System.out.printf("Tamanho da lista %d\n", lista.size());
			if (lista != null && lista.size() > 0) {
				BO b = lista.get(0);
				request.getSession().setAttribute("BOATUAL", b);
				message = String.format("BO encontrado nº %s\n", b.getNumero());
			}
		}
		
		request.getSession().setAttribute("MESSAGE", message);
		
		System.out.println( message );
		System.out.printf("A lista possui %d elementos \n", lista.size());
		
		response.sendRedirect("./bos.jsp");
	}

}
