<?php
require'connect.php';
$GroupName=" ";
$GroupName2="";
$publicMessage='';
session_start();

$User=$_SESSION['user'];
$Pass=$_SESSION['pass'];


//$GroupName=$_SESSION['groupname'];
//echo" this is it".$GroupName;
/*
 * Gets Id,First Name, Last Name from Registration table
 * 
 */
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
        $result2 = mysql_query("SELECT * FROM PublicGroup");
        while($row2 = mysql_fetch_array($result2))
        {   
            echo ("</option><option value = ".$row2['PublicGroup'].">".$row2['PublicGroup']."</option>");
        }
    }
  
    /*
     * Creates a group 
     */
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
            $sql="CREATE TABLE $GroupName(Owner INT ,MemberId INT ,Fname TEXT,Lname TEXT,Message TEXT )";
            $retval = mysql_query( $sql, $connect );
            
            if(! $retval )
            {
              echo "<script type='text/javascript'>alert('Could Not Create A Group');</script>";
              die('Could not create table: ' . mysql_error());
            }
            else
            {

              echo "<script type='text/javascript'>alert('Group Created Successfully');</script>";
              mysql_query("INSERT INTO PublicGroup(PublicGroup)"
                                . "VALUES('$GroupName')");
              mysql_query("INSERT INTO $GroupName(Owner,MemberId,Fname,Lname)"
                                . "VALUES('$Id','$Id','$Fname','$Lname')"); 
            }

        }
            mysql_close($connect);

    }
    /*
     * Delete the selected table
     * 
     */
if (isset($_POST['submit3']))
{
     $selected=$_POST['DelGroups'];
     if($selected=='Select Group')
        {
             echo "<script type='text/javascript'>alert('Please select a Group to Delete');</script>";
        }
        else
        {
   
    $result3 = mysql_query("SELECT * FROM $selected");
    while($row3 = mysql_fetch_array($result3))
    {   
        if(($Id==$row3['Owner'])&&($Id==$row3['MemberId']))
        {
        mysql_query("DROP TABLE $selected");
        mysql_query("DELETE FROM PublicGroup WHERE PublicGroup='$selected'");

            echo "<script type='text/javascript'>alert('Delete Process Complete');</script>";
        }
        else if(($Id!=$row3['Owner'])||($Id==$row3['MemberId']))
        {
           echo "<script type='text/javascript'>alert('You are not authorized to delte this group');</script>"; 
           break;
        }
        }
        
        }
}
if (isset($_POST['submit4']))
{   
    $publicMessage=$_POST['Message'];
      mysql_query("INSERT INTO PublicTalk(FName,LName,Talk)"
                                . "VALUES('$Fname','$Lname','$publicMessage')");
   
}
if (isset($_POST['submit2']))
{
    $selected=$_POST['GroupPublic'];
    if($selected!='Select Group')
    {
    $_SESSION['GroupPublic']=$selected;
     mysql_query("INSERT INTO $selected(MemberId,FName,LName)"
                                . "VALUES('$Id','$Fname','$Lname')");
    // echo"this is the talk ";$publicMessage;
     header("location:PublicMessage.php");
    // die();
    }
  else
  {
            echo "<script type='text/javascript'>alert('Please select a group to join');</script>";
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
           background-color:#006666;
            margin:auto;
            
        }
        #box1
        {
            height:450px;
            width:150px;
            background-color:#006666;
            float:left;
            overflow:scroll;
          
        }
        #box2
        {
            height:450px;
            width:450px;
            background-color:#000000;
            float:left;
          
           
        }
   
        #box2a
        {
            height:350px;
            width:450px;
            background-color:#666666;
            float:left;
            
            overflow:scroll;
        }
         #box2b
        {
            height:100px;
            width:450px;
            background-color:#0000FF;
          // margin-left:20px;
              
        }
        #box2c
        {
            height:100px;
            width:100px;
            background-color:#ffff00;
            float:right;
        }
        
        
        #box3
        {
            height:450px;
            width:300px;
           background-color:#006666;
            float:right;
        }     
        #box3a
        {
            height:250px;
            width:300px;
            background-color:#006666;
         
        }
           #box3b
        {
            height:100px;
            width:100px;
           background-color:#ffffff;
            float:left;
            margin-left:75px;
        }
        a
        {
            color:#ffffff;
            font-size:16px;
           text-decoration: none;
        }
        #box3b:hover
        {
            background-color:#0000FF;
        }
     a:hover
     {
         color:#0000FF;
     }
     label
     {
        // margin-left:20px;
         color:white;
     }
     
    </style>
    <body style="background-color:#cccccc">
        <br>
        <div id="container">
            <form  method="post">
            <div id="box1">
                <br>
                <center> <label> Available Groups </label></center>
              
                             <?php
                     require'connect.php';
            
                $result = mysql_query("SELECT * FROM PublicGroup");
                 echo"<ol>";
                 while($row = mysql_fetch_array($result))
                 {    
                   $link=$row['PublicGroup'];
                   
                 //  $_SESSION['link']=$link;
                   echo "<li>";
                 echo $link;
                   echo'</li>';
                }
                echo"</ol>";
                ?>
                   
                

            </div>
            <div id="box2">
            <div id="box2a">
                
                <?php 
                require'connect.php';
            
                $result = mysql_query("SELECT * FROM PublicTalk");
                 echo"<br>";
                 while($row = mysql_fetch_array($result))
                 {    
                   $Talk=$row['Talk'];
                   $name=$row['FName'];
                   $nameL=$row['LName'];
                   if($Talk!=Null)
                   {
                   echo"<label >";
                   echo $name." ".$nameL." :".$Talk."<br>";
                   
                   echo"</label>";
                   echo"<hr>";
                   }
                  
                }
                
            ?>
               </div>
                <div id="box2b">
                <textarea name='Message' style="width:350px;height:100px"></textarea>
                </div>
                
                <div id='box2c'>
                <input style="height:100px;width:100px;background-color:#0000FF;color:white;font-size:16px" type="submit" name='submit4' value="Send">
                </div>
            </div>
            
            <div id="box3"><br><br>
                    <div id="box3a">
            <center>   
           
            <input type="text" name="GroupName" style="width:150px" value= <?php $GroupName;?> >
            <input type="submit" name='submit1' value="Create group" style="height:30px;width:100px;background-color:#0000FF;color:white;font-size:12px">
            <br><br>
           
            <select name='GroupPublic'style="height:25px; width:150px">
            <option>Select Group</option>
            <?php echo GroupName();?>
            </select>
            <input  type="submit" name='submit2' value="Join group" style="height:30px;width:100px;background-color:#0000FF;color:white;font-size:12px">
        
            <br><br> 
            <select name='DelGroups'style="height:25px; width:150px">
            <option>Select Group</option>
            <?php echo GroupName();?>
            </select>
            <input type="submit" name='submit3' value="Delete group" style="height:30px;width:100px;background-color:#0000FF;color:white;font-size:12px">
            
          
            </center>  

                    </div>
                 <div id="box3b">
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
                   </form> 
        </div>
           
            
     

    </body>
</html>
