<?php
require'connect.php';
session_start();
$User=$_SESSION['user'];
$Pass=$_SESSION['pass'];


$GroupName=$_SESSION['link'];

$result = mysql_query("SELECT * FROM Registration");
while($row = mysql_fetch_array($result))
{   
    if(($User==$row['UserName'])&&($Pass==$row['Password']))
    {
    $Id=$row['Id'];
    $Fname=$row['Name'];
    $Lname=$row['LastName'];
  
    }
}




if($_POST)
{
    $Member=$_POST['GroupId'];
    $result = mysql_query("SELECT * FROM Registration");
    while($row = mysql_fetch_array($result))
{ 
    if($Member==$row['Id']) 
    {
        $FirstN=$row['Name'];
        $LastN=$row['LastName'];
    
    
    mysql_query("INSERT INTO $GroupName(Owner,MemberId,Fname,Lname)"
                    . "VALUES('$Id','$Member','$FirstN','$LastN')");
    echo "<script type='text/javascript'>alert('Group Member Added Successfully');</script>";
    }
}
    
}



?>








<html>
    <head >
    <div style="height:200px">
        <center> <img src="\sabin\picture\1.jpg" alt= " Image not found" style="height:125px;width:900px;margin:0;padding:0"></center>
        <center>  <h1 style="height:70px;width:900px;background-color: #666666;font-size:30;color: white;margin:0;padding:0">
        University Bazaar
        <p1 style="font-size:16;color: white"><center> 701 W Nedderman Dr, Arlington, TX 76019 </center></p1>
                   </h1></center>
    </div>
    </head>
    <style>
        #container{
            height:104px;
            width:900px;
            background-color:#cccccc;
           
            margin:auto;
        }
        #box1{
            height:104px;
            width:560px;
            background-color:#666666;
            border-style:solid;
            border-width:1px;
            float:left;
           }
         #box2{
            height:104px;
            width:208px;
            background-color:#cccccc;
            float:right;
           
        }
        #box2a{
            height:104px;
            width:104px;
            background-color:#cccccc;
            float:right;
           }
          #box2b{
            height:104px;
            width:104px;
            background-color:#cccccc;
            float:left;
           
        }
        #box2a:hover
        {
            background-color:#0000FF;
        }
         #box2b:hover
        {
            background-color:#0000FF;
        }
    </style>
    
    <body style="background-color:#cccccc"><br><br>
      <div id="container">
            <div id="box1">
                 <form method="post">
                    
                     <div style="height:104px; float:left;width:400px;background-color:#666666 ">
                         <label style="color:white;margin:2px;">Enter Group Id</label>
                          <input type="text" name="GroupId" style='margin: 20px;height:30px;width:300px'>
                     </div>
                     <div style="height:104px;float:left; width:150px;background-color:#666666"><br><br>
                         <input type="submit" value="submit" style="float:right;height:30px;width:150px;background-color:#0000FF;color:white;font-size:16px">
                     </div>
                
            </form>
            </div>
            <div id="box2">
                <div id="box2a">
                    <a href="Group.php"><img src="\sabin\picture\back.png" alt= " Image not found" style="padding:3;float:left;height:97; width:97"></a>
                </div>
            
            </div>
          
        </div>
    </center </body>
</html>