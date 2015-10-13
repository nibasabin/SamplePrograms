<?php
require'connect.php';
$Password='';
$Your='';
if (isset($_POST['submit1']))
    
{   
  //print_r($_POST);
    $Username = $_POST['UserName'];
    $ID=$_POST['ID'];
    $Name=$_POST['Name'];
    $LName=$_POST['LName'];
    $Pin= $_POST['SPin'];
    $DOB=$_POST['date'];
       
   $result = mysql_query("SELECT * FROM Registration");

        while($row = mysql_fetch_array($result))
        {
          //echo"dfafdafa <br>". $row['UserName'];
          if($ID==$row['Id'])
          {
            
            if(($Username==$row['UserName']) &&
                    ($ID==$row['Id'])&&
                    ($Name==$row['Name'])&&
                    ($LName==$row['LastName'])&&
                    ($Pin==$row['SecurityPin'])&&
                    ($DOB==$row['DateOfBirth']))

                 {
                   $Your='Your Password is :';
                   $Password=$row['Password'];
            }
            else
            {
               echo " Your information does not match our record";
            }
        }
        }
        
        
}
if (isset($_POST['submit2'])){
    header('Location:Login.php');
}


?>








<html>
    <title> Forgot Password </title>
    <head>
    <center><img src="\sabin\picture\logo.jpg" alt="lognot found" height=150px; width=800px; > </img>  </center>
    
    </head>
    <style>
        #container
        {
            height:425px;
            width:800px;
           // background-color: #666666;
            border-style: solid;
            border-width: 2px;
            margin:auto;
        }
        #container1
        {
            height:350px;
            width:800px;
            background-color:#006666;
       
            
        }
         #container2
        {
            height:75px;
            width:800px;
           // background-color:#B8860B;
           background-color:#006666;
                
            
        }
        #container2a
        {
            height:75px;
            width:400px;
         //  background-color:#000000;
           float:left;
        }
          #container2b
        {
            height:75px;
            width:400px;
            //  background-color:#ffffff;
              float:right;
        }
        #boxleft
        {
            height:350px;
            width:400px;
           // background-color: #000000;
            float:left;
            
            
        }
        #boxright
        {
            height:350px;
            width:400px;
           // background-color: #666666;
           // background-color:#cc0033;
            float:left;
        }
        #box1
        {
            height:350px;
            width:250px;
            float:right;
            font-size: 20px;
            //background-color: #666666;
            
        }
         #box2
        {
            height:350px;
            width:150px;
            color:white;
            
            font-size:20px;
            //background-color:#666666;
             
         
          
            
        }
    </style>
    
    <body style="background-color:#cccccc"> <br><br>
        <div id='container'>
        <form method="post">
            <div id='container1'>
                <div id="boxleft">
                
                    <div id="box1"><br><br>
                    
                    <input type="text" name="ID" style="width:200px;float:right"><br><br>
                    <input type="text" name= "UserName" style="width:200px;float:right"><br><br>
                    <input type="text" name="Name" style="width:200px;float:right"><br><br>
                    <input type="text" name="LName" style="width:200px;float:right"><br><br>
                    <input type="text" name="SPin" style="width:200px;float:right"><br><br>
                    <input type="date" name="date" style="width:200px;float:right"><br><br>
                    </div><!--box-->
                    
                    <div id="box2"><br><br>
                    <label style="float:right">ID        </label><br><br>
                    <label style="float:right">UserName  </label><br><br>
                    <label style="float:right">First Name  </label><br><br>
                    <label style="float:right">Last Name    </label> <br><br>
                    <label style="float:right">Security Pin  </label><br><br>
                    <label style="float:right">Date Of Birth  </label><br><br>
               
                </div><!--box2-->
                <br><br>
              </div><!--boxleft-->
              <div id="boxright"> <br><br><br>
            <center> <label style="color:white;font-size:20px;">Your Password </label></center><br>
            <center>   <div style="height:100px;width:275px;border-color:white;border-style:solid;border-width:2px">
                    <br><br> <label style="font-size:30px;color:white">  <?php echo $Password; ?> </label></div></center>
        
        </div ><!--boxright-->
        
        </div><!--container1-->
  
        <div id='container2'>
            <div id="container2a">
                <center>  <input type="submit" name='submit1'value="submit" style="height:50px;width:150px;color:white;background-color: #0000FF"> </center>
            </div>
            <div id="container2b">
                <center>     <input type="submit" name="submit2" value="Login" style="height:50px;width:150px;color:white;background-color: #0000FF"></center>
            </div>
             
            
              
          
        </div><!--container2-->
            
            

       
        
              </form>

        </div><!--container-->
    </body>
</html>