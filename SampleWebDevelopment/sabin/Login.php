

<?php
require'connect.php';
session_start(); 
$username='';


    $result = mysql_query("SELECT * FROM ExtAdd");
       
      

        while($row = mysql_fetch_array($result))
        {
           // header("Content-type: image/jpeg");
            
            $Address2=  "/sabin/picture/".$row['ExtAdd'];
         
        }
        //e
    if ($_POST)
    {  
        
        $username = $_POST['username'];
        $password = $_POST['password'];
          $_SESSION['user']=$username;
          $_SESSION['pass']=$password;
        $result = mysql_query("SELECT * FROM Registration");

        while($row = mysql_fetch_array($result))
        {
         if(($username=='Admin')&&($password=="Admin123"))
         {
             header('Location:AdminPage.php');
           
         }
        if($username==$row['UserName'])
        {
            if(($username==$row['UserName'])&&($password==$row['Password']))
            {
                   header("location:UserPage.php");
                    //die();

            }
           
         
            else if((strcmp($username,$row['UserName'])==0)&&(strcmp($password,$row['Password'])!=0))
            {
              echo "<script type='text/javascript'>alert('Please check our password');</script>";
               
            }
           
        }
        
        }
        if((strcmp($username,$row['UserName'])!=0)&&(strcmp($password,$row['Password'])!=0))
        {
          //  echo "<script type='text/javascript'>alert('User not found');</script>";
            
        }
     
    }
    
?>
<html>
    <head>
        <title>Login Form</title>
    </head>
    <style>
        #container
        {
            height : 400px;
            width : 800px;
            border-style: solid;
            border-width: 1px;
            margin:auto;
            background-color: #cccccc;
        }
        
        #logo
        {
           height : 100px;
           width:800px; 
           background-color: #666666;
          
        }
        #box1
        {
           height : 300px; 
           width:500px; 
           background-color: #ff3300;
           float: left;
        }
        #box2
        {
          height : 300px;
          width:300px; 
          background-color: #006666;
          color :white;
          font-family:monospace;
          float: right;
        }
        
    </style>
    <body stylebackground="\sabin\picture\1_1.jpg">
        <br> <br> <br> <br> <br> <br>
        <div id="container">
            
        
        <div id="logo">
            <p1 style = "font-size:60; color: White"><center> University Bazaar </center></p1>
            <p2 style = "font-size:16; color: white"><center> 701 W Nedderman Dr, Arlington, TX 76019</center></p2>
        </div><!--logo-->
        
         <div id="box1">
             
             <img  alt= " Image not found" width=500; height =300" src=<?php echo $Address2;?>></img>
        </div><!--box1-->
        
        
        <div id="box2">
            <div style="height : 300px ;width:20px;background-color:#006666;float: left"></div>
            <div style="height : 300px ;width:300px;background-color:#006666;">
                <br><br<br><br><br>
                <form method="post" >
                    Username:<input type="text" name="username"><br>
                    Password:<input type="password" name="password"><br><br><br><br>
                    <input type="submit" value="Login"> 
                       </form>
                <div style="height : 50px ;width:300px;background-color:#006666;">
                    <div style="height : 50px ;width:150px;float:right;background-color:#006666 ;">
                        <form name="ForgotPassword" action="ForgotPassword.php" method="post">
                      <input type="submit" value="Forgot Password">
                      </form>


                    </div>
                    <div style="height : 50px ;width:150px;background-color:#006666;">
                        <form name="Registration" action="Registration.php" method="post">
                        <input type="submit" value="New Registration">
                        </form>

                    </div>
                    
                </div>
            </div>
            
                  
           
               
        </div><!--box2-->
        
       
        
        
        <div id="box3">
            
            
        </div><!--box3-->
        
        </div><!--container-->
    
           
</body>
</html>