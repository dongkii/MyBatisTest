package first.member.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent e) {
		String name = (String)e.getSession().getAttribute("name");
		System.out.println(name+" 님이 접속하셨습니다.");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		System.out.println(e.getSession().getId()+"세션이 생성되었습니다.");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println(e.getSession().getId()+"세션이 파괴되었습니다.");
	}

}
