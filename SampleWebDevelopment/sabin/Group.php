<?php
require'connect.php';
$GroupName=" ";
session_start();

$User=$_SESSION['user'];
$Pass=$_SESSION['pass'];


//$GroupName=$_SESSION['groupname'];
$result = mysql_query("SELECT * FROM Registration");
while($row = mysql_fetch_array($result))
{   
    if(($User==$row['UserName'])&&($Pass==$row['Password']))
    {
    $Id=$row['Id'];
    $_SESSION['Id']=$Id;
    $Fname=$row['Name'];
    $_SESSION['Fname']=$Fname;
    $Lname=$row['LastName'];
    $_SESSION['Lname']=$Lname;
    }
}
    function GroupName()
    {
    $result2 = mysql_query("SELECT * FROM Groups");
    while($row2 = mysql_fetch_array($result2))
    {   
     
    
   
  echo ("</option><option value = ".$row2['GroupName'].">".$row2['GroupName']."</option>");
    }
    }

    
  
if (isset($_POST['submit1']))
{
    $GroupName=$_POST['GroupName'];
    $_SESSION['groupname']=$GroupName;
   
    if($GroupName=='')
    {
         echo "<script type='text/javascript'>alert('Please enter Group Name');</script>";
    }
    else
    {
        
    $sql="CREATE TABLE $GroupName(Owner INT ,MemberId INT ,Fname TEXT,Lname TEXT,Message TEXT,AdminId INT)";
                 
    
 

$retval = mysql_query( $sql, $connect );
if(! $retval )
{
  die('Could not create table: ' . mysql_error());
}

else
{
 

 echo "<script type='text/javascript'>alert('Group created successfully');</script>";
    mysql_query("INSERT INTO Groups(GroupName)"
                    . "VALUES('$GroupName')");
    $Admin=1000;
        mysql_query("INSERT INTO $GroupName(Owner,MemberId,Fname,Lname,AdminId)"
                    . "VALUES('$Id','$Id','$Fname','$Lname','$Admin')"); 
         
   }

mysql_close($connect);
}
}
if (isset($_POST['submit2']))
{
    $selected=$_POST['Groups'];
    $result3 = mysql_query("SELECT * FROM $selected");
    while($row3 = mysql_fetch_array($result3))
    {   
        if(($Id==$row3['Owner'])&&($Id==$row3['MemberId'])||($Id==1000))
        {
        mysql_query("DROP TABLE $selected");
        mysql_query("DELETE FROM Groups WHERE GroupName='$selected'");

        
            echo "<script type='text/javascript'>alert('Delete Process Complete');</script>";
            break;
        }
        else
        {
           echo "<script type='text/javascript'>alert('You are not authorized to delte this group');</script>"; 
            break;
        }
    }
  
   
}



?>




<html>
    
    <title>Group</title>
    <head >
        
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
        
    
    </head>
    <style>
        #container
        {
            height:450px;
            width:904px;
            background-color:#cccccc;
            margin:auto;
            
        }
        #box1
        {
            height:450px;
            width:500px;
            background-color:#cccccc;
            float:left;
            border-style:solid;
            border-width:2px;
        }
         #box2
        {
            height:450px;
            width:400px;
            background-color:#cccccc;
            float:right;
        }     
        #box2a
        {
            height:150px;
            width:400px;
            background-color:#cccccc;
         
        }
           #box2b
        {
            height:100px;
            width:100px;
            background-color:#cccccc;
            float:right;
            margin-right:50px;
            
            
        }
        #container1
        {
            height:450px;
            width:20px;
            background-color:#666666;
            float:left;
        }
         #container2
        {
            height:450px;
            width:480px;
            background-color:#666666;
            overflow:scroll;     
        }
        a
        {
            color:#ffffff;
            font-size:16px;
           text-decoration: none;
        }
        #box2b:hover
        {
            background-color:#0000FF;
        }
     a:hover
     {
         color:#0000FF;
     }
    </style>
    <body style="background-color:#cccccc">
        <br>
        <div id="container">
            <div id="box1">
            <div id="container1"></div>
            <div id="container2">
                <?php 
             require'connect.php';
            
                $result = mysql_query("SELECT * FROM Groups");
                 echo"<br>";
                 while($row = mysql_fetch_array($result))
                 {    
                   $link=$row['GroupName'];
                 //  $_SESSION['link']=$link;
                   $link="<a  href= GroupMessage.php?id=$link>" .$row['GroupName'] . "</a>"; 
                 echo $link."<br>";
                }
            ?>
            </div>
            
                
                 </div>
            
            <div id="box2"><br><br>
                    <div id="box2a">
            <center>   
            <form   method="post">
            <input type="text" name="GroupName" style="width:200px" value= <?php $GroupName;?> >
            <input type="submit" name='submit1' value="create group" style="height:50px;width:150px;background-color:#0000FF;color:white;font-size:16">
            <br><br> <select name='Groups'style="height:25px; width:200px">
            <option>Select Group</option>
            <?php echo GroupName();?>
            </select>
            <input type="submit" name='submit2' value="delete group" style="height:50px;width:150px;background-color:#0000FF;color:white;font-size:16">
            
            </form> 
            </center>  

                    </div>
                 <div id="box2b">
                     <?php
                     if(($User=='Admin')&&($Pass=='Admin123'))
                     {
                         $site="AdminPage.php";
                     }
                     else
                     {
                         $site="UserPage.php";
                     }
                     ?>
                     <a href=<?php echo $site;?>>  <img  src="\sabin\picture\home.jpg" alt= " Image not found" style=";padding:2px; height:95px; width:95px" ></a>
                    </div>
            
            
            </div>
        </div>
           
            
     

    </body>
</html>
