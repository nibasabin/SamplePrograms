
<?php
require'connect.php';
session_start();
  $link=$_SESSION['GroupPublic'];
  $Fname=$_SESSION['Fname'];
   $Lname=$_SESSION['Lname'];
  $writer='';
 
  $Id=$_SESSION['Id'];

$Message='';
if($_POST)
    {

    $Message=$_POST['Message'];
  

        mysql_query("INSERT INTO $link(MemberId,Fname,Lname,Message)"
                    . "VALUES('$Id','$Fname','$Lname','$Message')");

    }
?>
<html>
    
    <style>
        #container
        {
           height:590px;
           width:804px;
           margin: auto;
           background-color:#ff3300
          
        }
         #container1
        {
          height:590px;
          width:600px;
          float:left;
          background-color:#cccccc;
          border-style:solid;
          border-width:2px;
          
        }
          #container2
        {
          height:594px;
          width:200px;
          float:right;
          background-color:#B8860B;
         
          
        }
        #container2a
        {
          height:190px;
          width:200px;
     
          background-color:#006666;  
        }
  
     
        #container2b
        {
        height:384px;
        width:200px;
        background-color:#006666; 
        overflow:scroll;
        color:white;
        }
      
        #box1
        { height:400px;
          width:600px;
          background-color:#666666;
          color:#ffffff;
          overflow:scroll;
        }
         #box2
        { height:150px;
          width:600px;
          background-color:#666666;
          color:#ffffff;
        }
         #box2a
        {
            height:150px;
            width:150px;
            background-color:#666666;
            float:right;
        }
           #box2b
        {
            height:150px;
            width:450px;
      
            background-color:#666666;
            
        }
        
    </style>
    <header style="padding-left:190px;font-size:16px;color:#0000FF"><?php echo"Welcome to ".$link;?></header>
     <body style="background-color:#cccccc">
         <div id="container">
        <div id="container1">
           <div id="box1">
               
           <?php 
           require'connect.php';
                
             $result = mysql_query("SELECT * FROM $link");
           
            
          
            {  while($row = mysql_fetch_array($result))
                { 
                if($row['Message']!=null)
                {
                $Message=$row['Message'];
                $writer=$row['Fname']." ".$row['Lname'];
                echo $writer." : ".$Message."<br>";
                }
            }
            
            }
        
       
        
            ?>
           </div><br><br>
           <div id="box2">
               <form method="post">
                   <div id="box2a"> <br><br>
                   <center> <input style="height:50px;width:100px;background-color: #0000FF;color:white" type="submit" value="Send"></center>
                   </div>
               
                   <div id="box2b"><br>
                   <center>  <textarea name='Message' style="width:430px;height:120px"></textarea></center>
                   </div>
               </form>
                   
           </div>
        </div>
         <div id="container2">
             <div id="container2a"><br><br>
                 <form action="PublicGroup.php">
                    <center> <input  type="submit" value="Go Back"style="height:50px;width:150px;background-color:#0000FF;color:white;font-size:16"></center>
             
                 </form>
                 </div>
             
             <br>
             <div id="container2b"><br>
                 <center>    <label style="font-size:16px">
                 <?php 
                 
                 echo"<U> Group Members</U> <br>";
                 require'connect.php';
                 $GMember[]=null;
                $result = mysql_query("SELECT * FROM $link");
                while($row = mysql_fetch_array($result))
                {  
                   
                if(in_array($row['Fname']." ".$row['Lname'],$GMember))
                { echo"";
                     
                  
                }
                else
                {$GMember[]=$row['Fname']." ".$row['Lname'];
                }
                }
                $i=0;
                $size=sizeof($GMember);
              
                   
                while($i!=$size)
                {
                    
                echo $GMember[$i]."<br>";
                $i=$i+1;
                }
                
           
                
                 ?>
                     </label></center>
             </div>
         </div>
         </div>
         </div>
             
     </body>
</html>