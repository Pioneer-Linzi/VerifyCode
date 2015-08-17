这个类是用于输出駩证码的一个servlet 
用法是 
<img src="path">


路径： path=${pageContext.request.contextPath}/VCodeServlet"

駩证码存入在request.getSession().getAttribute("verifyCode");中，