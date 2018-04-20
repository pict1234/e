#include <stdlib.h> 
#include <stdio.h> 
#include "mpi.h" 
#include<string.h> 
int main(int argc, char **argv) 
{ 
  MPI_Comm client; 
  MPI_Status status; 
  char port_name[MPI_MAX_PORT_NAME],ch; 
  int degree,radian,input;
  int size, again, i,j; 
  MPI_Init(&argc, &argv); 
  MPI_Comm_size(MPI_COMM_WORLD, &size); 
  MPI_Open_port(MPI_INFO_NULL, port_name); 
  printf("Server available at port: %s\n", port_name); 
  i=0; 
 
  while (1) { 
      MPI_Comm_accept(port_name, MPI_INFO_NULL, 0, MPI_COMM_WORLD, &client); 
      again = 1; 
      while (again) { 
       	  MPI_Recv(&input, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, client, &status); 
      	  switch (status.MPI_TAG) { 
     
              case 1: 
                 
                  radian = 10*degree;
                  printf("\nReciprocal is : %d\n",radian); 

                  // sending back to client tag =2
	          MPI_Send(&radian, 1, MPI_INT, 0, 2, client);          

 		  //send tag=1 to indicate end of string   
 		  MPI_Send(&radian, 1, MPI_INT, 0, 1, client); 
                  MPI_Comm_disconnect(&client); 
                  again = 0; 
                  break; 
              case 2: 
                  degree = input;
                  printf("\nReceived Value is->: %d\n",degree); 
                  break; 

          } 
      } 
  } 
}
