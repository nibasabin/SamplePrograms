

<?php

require('connect.php');
$Id='';
function ProfessorName()
{
 $myData =mysql_query (  "SELECT * FROM Professor");  
                    
while($record = mysql_fetch_array($myData))
    {
        echo("</option><option value = ".$record['Name']." ". $record['LastName'].">".$record['Name']." ". $record['LastName']."</option>");
     }
}

function Dept()
        {
    $myData =mysql_query (  "SELECT * FROM Department"); 
    
    while($record = mysql_fetch_array($myData))
                    {
                         echo("</option><option value = ".$record['Dept'].">".$record['Dept']."</option>");
                         
                    }
                    }

if(isset($_POST['submit1'])){
$Rating = $_POST['Rate'];

$Professor = $_POST['Professor'];

$Dept = $_POST['Department'];

$Comment = $_POST['Message'];



$myData =mysql_query (  "SELECT * FROM Professor");  
                    
                    while($record = mysql_fetch_array($myData))
                    {
                      
                     
                        if(($Professor=='Professor')||($Rating=='Ratings')||($Dept=='Department'))
                        {
                              echo "<script type='text/javascript'>alert('Please select your choices');</script>";
                              break;
                        }
                        else
                        {
                        if($Professor==$record['Name'])
                            { 
                           
                            $Id = $record['ID'];
                           
                             mysql_query("INSERT INTO Ratings(Id,Name,Dept,AvgRating)"
                            . "VALUES('$Id','$Professor','$Dept','$Rating')");
                 

                        mysql_query("INSERT INTO Comment(ID,Comment)"."VALUES('$Id','$Comment')");
                        mysql_query("INSERT INTO Avgrating(Id,ratings)"."VALUES('$Id','$Rating')");
                           echo "<script type='text/javascript'>alert('Rating Successfully Completed');</script>";
                       // header("location:Ratings.php");
                                    }
                        }
                    }
                       
                       
}
if(isset($_POST['submit2']))
{
    header('Location:Ratings.php');
}

?>

<html>
     <head >
        
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
</head>
<style>


    #box2
    {
        height:400px;
        width:750px;
        background-color:#006666;
        margin:auto;
      
     
        
    }
    #box2a
    {
        height :366px;
        width:250px;
        float:left;
        background-color:#006666;
        font-size:20px;
        color:white;
        
    }
        #box2b
    {
        height :366px;
        width:250px;
        float:left;
        background-color:#006666;
    }
          #box2c
    {
        height :366px;
        width:250px;
        float:right;
        background-color:#006666;
    }

</style>
<body style="background-color:#cccccc"> <br><br>
           
        
             
               
            
             <div id='box2'>
                 
                 <center> <label style="color:yellow;font-size:30px; ">Rate Professor</label><br></center>
                  <form method="post">
                 <div id='box2a'>
                     <br> <br> <label style="margin-left:125px">Name </label><br>
                     <br><label style ="margin-left:125px;">Department</label><br>
                     <br><label style="margin-left:125px">Ratings </label><br>
                     <br> <label style ="margin-left:125px">Comment </label><br>
                 </div>
                 
                  <div id='box2b'>
                      <br><br>
                  <select style='height:30px; width:200px;'name ='Professor'>
                  <option value="Professor">Professor</option>
                  <?php ProfessorName()?> 
                  </select>
                      <br><br>
                
                 <select style='height:30px; width:200px;' name ='Department'>
                 <option value="Department">Department</option>
                 <?php Dept()?>
                 </select><br><br>
                      
                 <select style='height:30px; width:200px;' name='Rate'>
                 <option value="Ratings">Ratings</option>  
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                 </select><br><br>
                <textarea name='Message' style="width:400px;height:150px;float:left"> </textarea>
                     
                  </div>
                   <div id="box2c">
                       <br>
                       <br>
                   <input style='width:150px;height:50px;background-color:blue;float:right;margin-right:30px;color:white;' name='submit1' type='submit' value="Submit">
                        
                 
                       <br>
                       <br>
                       <br>
                       
                    <input name='submit2' style='width:150px;height:50px;background-color:blue;float:right;margin-right:30px;color:white;' type='submit' value='back'>
                       
                     
                 </div>
                        </form>
             </div>
           
           
    

                       
       
                   
                      
                  

        
        
    

</html>
        