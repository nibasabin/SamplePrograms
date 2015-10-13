
    <?php
  require('connect.php');
        
       $Fname	 		= '';
        $Lname                  = '';
        $StudentId              = '';
        $UserName		= '';
        $Password		= '';
        $ConfirmPassword	= '';
        $Email                  = '';
        $ConfirmEmail		= '';
        $SecurityPin            = '';
        $DateOfBirth            = '';
      
     
 if (isset($_POST['submit1']))
     {
   
        $Fname	 		= $_POST['Name'];
        $Lname                  = $_POST['LastName'];
        $StudentId              = $_POST['Id'];
        $UserName		= $_POST['UserName'];
        $Password		= $_POST['Password'];
        $ConfirmPassword	= $_POST['ConfirmPassword'];
        $Email                  = $_POST['Email'];
        $ConfirmEmail		= $_POST['ConfirmEmail'];
        $SecurityPin            = $_POST['SecurityPin'];
        $DateOfBirth            = $_POST['DateOfBirth'];
        $test1=0;
        $test2=0;
       
            

    $result = mysql_query("SELECT * FROM Members");
    while($row = mysql_fetch_array($result))
   {
     //echo"studentId".$StudentId."<br>";
     //echo"Id".$row['Id'];
    if(($StudentId==$row['Id'])&& ($Fname==$row['Fname'])&&($Lname==$row['Lname']))
      {
        $test1=1;
      }

   }
   $result1 = mysql_query("SELECT * FROM Registration");
   while($row2 = mysql_fetch_array($result1))
   {
     if($StudentId==$row2['Id'])
        {
            $test2=1;               
                   
        }
   }


    if(($test1==1)&&($test2==0))
    {
      if($Fname==''||$Lname==''||$ConfirmEmail==''||$ConfirmPassword==''||$DateOfBirth==''||$Email==''||$Password==''||$SecurityPin==''||$StudentId==''||$UserName=='')
         {
             echo "<script type='text/javascript'>alert('Please complete the form');</script>";
         }
         
        if(($Password==$ConfirmPassword)&&($Email==$ConfirmEmail)&&($ConfirmPassword||$ConfirmEmail||$DateOfBirth||$Email||$Fname||$Lname||$Password||$SecurityPin||$StudentId||$UserName!==''))
        {
            mysql_query("INSERT INTO Registration(Name,LastName,Id,UserName,Password,Email,SecurityPin,DateOfBirth)"
                    . "VALUES('$Fname','$Lname','$StudentId','$UserName','$Password','$Email','$SecurityPin','$DateOfBirth')");
                     header('Location:RegistrationComplete.php');
        }
             
        if($Password!=$ConfirmPassword)
           {
               echo "<script type='text/javascript'>alert('Your password and confirm Password does not match');</script>";
           }
        if ($Email!=$ConfirmEmail)
            {
                echo "<script type='text/javascript'>alert('Your Email and confirm Email does not match');</script>";

            }
    }
       
     if($test1==0)
      {
        echo "<script type='text/javascript'>alert('sorry.. Only Members can register');</script>";
       }
    if($test2==1)
    {
      echo "<script type='text/javascript'>alert('You have already registered..');</script>";
     }
     }
     if(isset($_POST['submit2']))
     {
         header('Location:Login.php');
     }
      
      
         
        /*
      
		
			
			
     
    }  $qry = mysql_query($query);
          if($qry){
				
                                        header('Location:Login.php');
					echo  "Registered Successfully";
					
			}
			else {	
					echo "failed ". mysql_error();	
				
				}
         }
    */
        ?>
        
       
<html>
    <style type="text/css">
        
        #container
        {
            height:500px;
            width:1000px;
            background-color:#006666;
            border-style:solid;
            border-width:1px;
            margin:auto;
        }
        #box1
        {
            height:100px;
            width:1000px;
            float:left;
            background-color:#666666;
         }
         #box2
         {
            height:400px;
            width:1000px;
            float:right;
            background-color:#000000;
        }
        #box2a
        {
            height:400px;
            width:800px;
            float:left;
            background-color:#0000FF;
        }
          #box2b
        {
            height:400px;
            width:200px;
            float:right;
            background-color:#cccccc;
        }

        
        
    </style>
   
    <body style="background-color:#cccccc"><br><br>
        <div id="container">
            <div id="box1">
            <center> <label style="color:white;font-size:50px">University Bazaar </label></center>
             <center> <label style="color:white;font-size:16px">701 W Nedderman Dr, Arlington, TX 76019</label></center>
                </div>
                
            
            <div id="box2">
                <form method="post">
                <div id="box2a">
                <div style="height :400px; width:400px;float:right;background-color:#cccccc">
          
                <br>
                <label style="width:250px;margin-left:70px"> Last Name : </label><br>
                <input type="text" name="LastName" style="width:250px;margin-left:70px" value=<?php echo $Lname; ?> ><br><br>
                <label style="width:250px;margin-left:70px"> Student/Faculty ID : </label><br>
                <input type="number" name="Id" style="width:250px;margin-left:70px" value=<?php echo $StudentId;?> <br><br><br>
                <label style="width:250px;margin-left:70px"> Confirm Password : </label><br>
                <input type="password" name="ConfirmPassword" style="width:250px;margin-left:70px" value=<?php echo $ConfirmPassword;?> ><br><br>
                <label style="width:250px;margin-left:70px"> Confirm Email :</label><br>
                <input type="text" name="ConfirmEmail" style="width:250px;margin-left:70px" value=<?php echo $ConfirmEmail;?> ><br><br>
                <label style="width:250px;margin-left:70px"> Security Pin :</label><br>
                <input type="text" name="SecurityPin" style="width:250px;margin-left:70px" value=<?php echo $SecurityPin;?> ><br><br>
                 </div>
                    
                <div style="height :400px; width:400px;background-color:#cccccc">
                <br>
                <label style="width:250px;margin-left:70px"> First Name : </label><br>       
                <input type="text" name="Name" style="width:250px;margin-left:70px" value=<?php echo $Fname;?> ><br><br>
                 <label style="width:250px;margin-left:70px"> UserName :</label><br>
                <input type="text" name="UserName" style="width:250px;margin-left:70px" value=<?php echo $UserName;?> ><br><br>
                <label style="width:250px;margin-left:70px"> Password : </label><br>
                <input type="password" name="Password" style="width:250px;margin-left:70px" value=<?php echo $Password;?> ><br><br>
                <label style="width:250px;margin-left:70px"> Email : </label><br>
                <input type="text" name="Email" style="width:250px;margin-left:70px" value=<?php echo $Email;?> ><br><br>
                <label style="width:250px;margin-left:70px"> Date of Birth :</label><br>
                <input type="date" name="DateOfBirth" style="width:250px;margin-left:70px" value=<?php echo $DateOfBirth;?> ><br><br>
                </div>
                    
                </div>
                <div id="box2b"><br><br>
                  
                        <center>  <input type="submit" name='submit1' value="Register" name="Register" style="height: 50px; width: 150px;background-color:#0000FF;color:white" ></center>
                        <br>

                  
                        <center><input type="submit" name='submit2'value="Login"style=" height: 50px;width: 150px;background-color:#0000FF;color:white" ></center>
                    </form>
              
                </div>
                
                
          
            </div>
            
       
       
    
   

        

</body>
</html>

