#include <stdlib.h> 
#include <stdio.h> 
#include <string.h> 
#include "mpi.h" 
int main( int argc, char **argv ) 
{ 
  MPI_Comm server; 
  MPI_Status status; 
  char port_name[MPI_MAX_PORT_NAME],ch; 
  int deg,res,input;
  int i, tag,again; 
  MPI_Init(&argc, &argv); 
  strcpy(port_name, argv[1]);
  MPI_Comm_connect(port_name, MPI_INFO_NULL, 0, MPI_COMM_WORLD, &server); 
  
  // accept input string 
  printf("\nEnter the Value :\n"); 
  scanf("%d",&deg); 
  
  input = deg;
 
  MPI_Send(&deg,1,MPI_INT,0, 2,server);	//tag =2 for sending value

  MPI_Send(&deg, 1, MPI_INT, 0, 1, server); // done sending value to the server indicated by tag=1

  // Receive the reversed string from server and display it 
  again=1; 
  while (again) { 
     MPI_Recv(&input, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, server, &status); 
      switch (status.MPI_TAG) { 
   	   case 2: 
		res = input;   //tag =2 for accepting value
                break; 
      	   case 1:  again=0; 	//tag =1 indicates end of value
               break;    
	} 
  } 

  printf("\nValue is: %d\n\n",deg); 
  printf("\nReciprocal is: %d\n\n",res); 
  MPI_Comm_disconnect(&server); 
  MPI_Finalize(); 
  return 0; 
}
