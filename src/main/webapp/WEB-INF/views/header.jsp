<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="viho admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, viho admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="pixelstrap">
    <link rel="icon" href="../assets/images/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="../assets/images/favicon.png" type="image/x-icon">
    <title>20220508_DemoProject</title>
    <!-- Google font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <!-- Font Awesome-->
    <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome.css">
    <!-- ico-font-->
    <link rel="stylesheet" type="text/css" href="./assets/css/icofont.css">
    <!-- Themify icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/themify.css">
    <!-- Flag icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/flag-icon.css">
    <!-- Feather icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/feather-icon.css">
    <!-- Plugins css start-->
    <link rel="stylesheet" type="text/css" href="./assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/chartist.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/date-picker.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/prism.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/vector-map.css">
    <!-- Plugins css Ends-->
        <!-- Plugins css start-->
    <link rel="stylesheet" type="text/css" href="./assets/css/dropzone.css">
    <!-- Bootstrap css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/bootstrap.css">
    <!-- App css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
    <link id="color" rel="stylesheet" href="../assets/css/color-1.css" media="screen">
    <!-- Responsive css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/responsive.css">
  </head>
<body>
	   <!-- Page Header Start-->
      <div class="page-main-header">
        <div class="main-header-right row m-0">
          <div class="main-header-left">
            <div class="logo-wrapper"><a href="index.html"><img class="img-fluid" src="../assets/images/logo/logo.png" alt=""></a></div>
            <div class="dark-logo-wrapper"><a href="index.html"><img class="img-fluid" src="../assets/images/logo/dark-logo.png" alt=""></a></div>
            <div class="toggle-sidebar"><i class="status_toggle middle" data-feather="align-center" id="sidebar-toggle"></i></div>
          </div>
          <div class="left-menu-header col">
            <ul>
              <li>
                <form class="form-inline search-form">
                  <div class="search-bg"><i class="fa fa-search"></i>
                    <input class="form-control-plaintext" placeholder="Search here.....">
                  </div>
                </form><span class="d-sm-none mobile-search search-bg"><i class="fa fa-search"></i></span>
              </li>
            </ul>
          </div>
          <div class="nav-right col pull-right right-menu p-0">
            <ul class="nav-menus">
              <li><a class="text-dark" href="#!" onclick="javascript:toggleFullScreen()"><i data-feather="maximize"></i></a></li>
              <li class="onhover-dropdown">
                <div class="bookmark-box"><i data-feather="star"></i></div>
                <div class="bookmark-dropdown onhover-show-div">
                  <div class="form-group mb-0">
                    <div class="input-group">
                      <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-search"></i></span></div>
                      <input class="form-control" type="text" placeholder="Search for bookmark...">
                    </div>
                  </div>
                  <ul class="m-t-5">
                    <li class="add-to-bookmark"><i class="bookmark-icon" data-feather="inbox"></i>Email<span class="pull-right"><i data-feather="star"></i></span></li>
                    <li class="add-to-bookmark"><i class="bookmark-icon" data-feather="message-square"></i>Chat<span class="pull-right"><i data-feather="star"></i></span></li>
                    <li class="add-to-bookmark"><i class="bookmark-icon" data-feather="command"></i>Feather Icon<span class="pull-right"><i data-feather="star"></i></span></li>
                    <li class="add-to-bookmark"><i class="bookmark-icon" data-feather="airplay"></i>Widgets<span class="pull-right"><i data-feather="star">   </i></span></li>
                  </ul>
                </div>
              </li>
              <li class="onhover-dropdown">
                <div class="notification-box"><i data-feather="bell"></i><span class="dot-animated"></span></div>
                <ul class="notification-dropdown onhover-show-div">
                  <li>
                    <p class="f-w-700 mb-0">You have 3 Notifications<span class="pull-right badge badge-primary badge-pill">4</span></p>
                  </li>
                  <li class="noti-primary">
                    <div class="media"><span class="notification-bg bg-light-primary"><i data-feather="activity"> </i></span>
                      <div class="media-body">
                        <p>Delivery processing </p><span>10 minutes ago</span>
                      </div>
                    </div>
                  </li>
                  <li class="noti-secondary">
                    <div class="media"><span class="notification-bg bg-light-secondary"><i data-feather="check-circle"> </i></span>
                      <div class="media-body">
                        <p>Order Complete</p><span>1 hour ago</span>
                      </div>
                    </div>
                  </li>
                  <li class="noti-success">
                    <div class="media"><span class="notification-bg bg-light-success"><i data-feather="file-text"> </i></span>
                      <div class="media-body">
                        <p>Tickets Generated</p><span>3 hour ago</span>
                      </div>
                    </div>
                  </li>
                  <li class="noti-danger">
                    <div class="media"><span class="notification-bg bg-light-danger"><i data-feather="user-check"> </i></span>
                      <div class="media-body">
                        <p>Delivery Complete</p><span>6 hour ago</span>
                      </div>
                    </div>
                  </li>
                </ul>
              </li>
              <li>
                <div class="mode"><i class="fa fa-moon-o"></i></div>
              </li>
              <li class="onhover-dropdown"><i data-feather="message-square"></i>
                <ul class="chat-dropdown onhover-show-div">
                  <li>
                    <div class="media"><img class="img-fluid rounded-circle me-3" src="../assets/images/user/4.jpg" alt="">
                      <div class="media-body"><span>Ain Chavez</span>
                        <p class="f-12 light-font">Lorem Ipsum is simply dummy...</p>
                      </div>
                      <p class="f-12">32 mins ago</p>
                    </div>
                  </li>
                  <li>
                    <div class="media"><img class="img-fluid rounded-circle me-3" src="../assets/images/user/1.jpg" alt="">
                      <div class="media-body"><span>Erica Hughes</span>
                        <p class="f-12 light-font">Lorem Ipsum is simply dummy...</p>
                      </div>
                      <p class="f-12">58 mins ago</p>
                    </div>
                  </li>
                  <li>
                    <div class="media"><img class="img-fluid rounded-circle me-3" src="../assets/images/user/2.jpg" alt="">
                      <div class="media-body"><span>Kori Thomas</span>
                        <p class="f-12 light-font">Lorem Ipsum is simply dummy...</p>
                      </div>
                      <p class="f-12">1 hr ago</p>
                    </div>
                  </li>
                  <li class="text-center"> <a class="f-w-700" href="javascript:void(0)">See All     </a></li>
                </ul>
              </li>
              <li class="onhover-dropdown p-0">
              <c:if test="${mem != null}">
              <span>${mem.name}님 환영합니다 (${mem.auth == 'ROLE_USER' ? "사용자" : "관리자"})</span>
                <button class="btn btn-primary-light" type="button"><a href="./logout.do"><i data-feather="log-Out"></i>Log Out</a></button>
               </c:if>
                <c:if test="${mem == null}">
                <button class="btn btn-primary-light" type="button"><a href="./loginForm.do"><i data-feather="log-In"></i>Log In</a></button>
                </c:if>
              </li>
            </ul>
          </div>
          <div class="d-lg-none mobile-toggle pull-right w-auto"><i data-feather="more-horizontal"></i></div>
        </div>
      </div>
      <!-- Page Header Ends                              -->
      <!-- Page Body Start-->
      <div class="page-body-wrapper sidebar-icon">
        <!-- Page Sidebar Start-->
        <header class="main-nav">
          <div class="sidebar-user text-center"><a class="setting-primary" href="javascript:void(0)"><i data-feather="settings"></i></a><img class="img-90 rounded-circle" src="../assets/images/dashboard/1.png" alt="">
            <div class="badge-bottom"><span class="badge badge-primary">New</span></div><a href="user-profile.html">
              <h6 class="mt-3 f-14 f-w-600">Emay Walter</h6></a>
            <p class="mb-0 font-roboto">Human Resources Department</p>
            <ul>
              <li><span><span class="counter">19.8</span>k</span>
                <p>Follow</p>
              </li>
              <li><span>2 year</span>
                <p>Experince</p>
              </li>
              <li><span><span class="counter">95.2</span>k</span>
                <p>Follower </p>
              </li>
            </ul>
          </div>
          <nav>
            <div class="main-navbar">
              <div class="left-arrow" id="left-arrow"><i data-feather="arrow-left"></i></div>
              <div id="mainnav">           
                <ul class="nav-menu custom-scrollbar">
                  <li class="back-btn">
                    <div class="mobile-back text-end"><span>Back</span><i class="fa fa-angle-right ps-2" aria-hidden="true"></i></div>
                  </li>
                  <li class="sidebar-main-title">
                    <div>
                      <h6>General             </h6>
                    </div>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="home"></i><span>Dashboard</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="index.html">Default</a></li>
                      <li><a href="dashboard-02.html">Ecommerce</a></li>
                    </ul>
                  </li>
                
                  <li class="sidebar-main-title">
                    <div>
                      <h6>Components             </h6>
                    </div>
                  </li>
               
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="edit-3"></i><span>게시판</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="form-builder-1.html">회원리스트(MPA)</a></li>
                      <li><a href="./boardList.do">계층형게시판(SPA)</a></li>
                      <li><a href="pagebuild.html">답글형게시판</a></li>
                      <li> <a href="button-builder.html">스크롤게시판</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="cloud-drizzle"></i><span>Animation</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="animate.html">Animate</a></li>
                      <li><a href="scroll-reval.html">Scroll Reveal</a></li>
                      <li><a href="AOS.html">AOS animation</a></li>
                      <li><a href="tilt.html">Tilt Animation</a></li>
                      <li><a href="wow.html">Wow Animation</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="cloud"></i><span>Buttons</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="buttons.html">Default Style</a></li>
                      <li><a href="buttons-flat.html">Flat Style</a></li>
                      <li><a href="buttons-edge.html">Edge Style</a></li>
                      <li><a href="raised-button.html">Raised Style</a></li>
                      <li><a href="button-group.html">Button Group</a></li>
                    </ul>
                  </li>
                 
                  <li class="sidebar-main-title">
                    <div>
                      <h6>Forms</h6>
                    </div>
                  </li>
                  <li class="dropdown">          <a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="sliders"></i><span>Form Controls                </span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="form-validation.html">Form Validation</a></li>
                      <li><a href="base-input.html">Base Inputs</a></li>
                      <li><a href="radio-checkbox-control.html">Checkbox & Radio</a></li>
                      <li><a href="input-group.html">Input Groups</a></li>
                      <li><a href="megaoptions.html">Mega Options </a></li>
                    </ul>
                  </li>
                  <li class="dropdown">          <a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="package"></i><span>Form Widgets</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="datepicker.html">Datepicker</a></li>
                      <li><a href="time-picker.html">Timepicker</a></li>
                      <li><a href="datetimepicker.html">Datetimepicker</a></li>
                      <li><a href="daterangepicker.html">Daterangepicker</a></li>
                      <li><a href="touchspin.html">Touchspin</a></li>
                      <li><a href="select2.html">Select2</a></li>
                      <li><a href="switch.html">Switch</a></li>
                      <li><a href="typeahead.html">Typeahead</a></li>
                      <li><a href="clipboard.html">Clipboard </a></li>
                    </ul>
                  </li>
                  <li class="dropdown">          <a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="layout"></i><span>Form layout</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="default-form.html">Default Forms</a></li>
                      <li><a href="form-wizard.html">Form Wizard 1</a></li>
                      <li><a href="form-wizard-two.html">Form Wizard 2</a></li>
                      <li><a href="form-wizard-three.html">Form Wizard 3</a></li>
                    </ul>
                  </li>
                  <li class="sidebar-main-title">
                    <div>
                      <h6>Table</h6>
                    </div>
                  </li>
                  <li class="dropdown">          <a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="server"></i><span>Bootstrap Tables             </span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="bootstrap-basic-table.html">Basic Tables</a></li>
                      <li><a href="bootstrap-sizing-table.html">Sizing Tables</a></li>
                      <li><a href="bootstrap-border-table.html">Border Tables</a></li>
                      <li><a href="bootstrap-styling-table.html">Styling Tables</a></li>
                      <li><a href="table-components.html">Table components</a></li>
                    </ul>
                  </li>

                  <li class="sidebar-main-title">
                    <div>
                      <h6>Applications             </h6>
                    </div>
                  </li>
                  <li class="dropdown">          <a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="box"></i><span>Project                </span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="projects.html">Project List</a></li>
                      <li><a href="projectcreate.html">Create new             </a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title link-nav" href="file-manager.html"><i data-feather="git-pull-request"></i><span>File manager</span></a></li>
                  
                
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="mail"></i><span>Email</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="email_inbox.html">Mail Inbox</a></li>
                      <li><a href="email_read.html">Read mail</a></li>
                      <li><a href="email_compose.html">Compose</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="message-circle"></i><span>Chat</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="chat.html">Chat App</a></li>
                      <li><a href="chat-video.html">Video chat</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="nav-link menu-title" href="javascript:void(0)"><i data-feather="users"></i><span>Users</span></a>
                    <ul class="nav-submenu menu-content">
                      <li><a href="user-profile.html">Users Profile</a></li>
                      <li><a href="edit-profile.html">Users Edit</a></li>
                      <li><a href="user-cards.html">Users Cards</a></li>
                    </ul>
                  </li>
                   </ul>
              </div>
              <div class="right-arrow" id="right-arrow"><i data-feather="arrow-right"></i></div>
            </div>
          </nav>
        </header>
        <!-- Page Sidebar Ends-->

</body>
</html>