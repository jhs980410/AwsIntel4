package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		RequestDispatcher rd = null;

		String mNo = "";
		
		try {
			mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);

			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = memberDao.memberSelectOne(no);
			
			if (memberDto == null) {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
			
			req.setAttribute("memberDto", memberDto);
			rd = req.getRequestDispatcher("./MemberUpdateForm.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDto memberDto = null;
		
		Connection conn = null;
		
		try {
			
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String mNo = req.getParameter("mNo");
			int no = Integer.parseInt(mNo);
			
			memberDto = new MemberDto();
			memberDto.setEmail(email);
			memberDto.setName(name);
			memberDto.setNo(no);
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			int result = memberDao.memberUpdate(memberDto);

			if(result == 0){
				System.out.println("회원 정보 조회가 실패하였습니다.");
			}
			
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
