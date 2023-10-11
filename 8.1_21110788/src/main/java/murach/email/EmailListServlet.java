package murach.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/index.jsp";
		request.setCharacterEncoding("UTF-8");
		// get current action
		String action = request.getParameter("action");
		ArrayList<User> users = new ArrayList<>();

		if (action == null) {
			action = "join";
		}
		// perform action and set URL to appropriate page
		if (action.equals("join")) {
			url = "/index.jsp"; // the "join" page

		} else if (action.equals("add")) {
			// get parameter from the request
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String dateOfBirth = request.getParameter("dateofbirth");
			String heardFrom = request.getParameter("radio_c");
			String updates = request.getParameter("checkbox_c");
			String contactVia = request.getParameter("typeofContact");
			String message = "";
			if (updates == null)
				updates = "No";
			User user = new User(firstName, lastName, email, dateOfBirth, heardFrom, updates, contactVia);
			users.add(user);
			if (firstName == null || lastName == null || email == null || dateOfBirth == null || firstName.isEmpty()
					|| lastName.isEmpty() || email.isEmpty() || dateOfBirth.isEmpty()) {
				message = "Please fill out all four text boxes.";
				url = "/index.jsp";
			} else {
				GregorianCalendar currentDate1 = new GregorianCalendar();
				int currentDay = currentDate1.get(Calendar.DAY_OF_MONTH);
				int currentMonth = currentDate1.get(Calendar.MONTH);
				message = "Here is the information that you enter:";
				url = "/thanks.jsp";
				request.setAttribute("currentDay", currentDay);
				request.setAttribute("currentMonth", currentMonth);
			}
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		Date currentDate = new Date();
		request.setAttribute("currentDate", currentDate);

		User user1 = new User("Quyển Tư", "Lượng", "qtl@example.com", "12/2/2000", "News", "Yes", "Email");
		User user2 = new User("Vân Chi", "Sam", "vcs@example.com", "18/3/2001", "News", "Yes", "Email");

		users.add(user1);
		users.add(user2);
		request.setAttribute("users", users);

		// forward request and response objects to specified URL
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
		doPost(request, response);
	}
}
