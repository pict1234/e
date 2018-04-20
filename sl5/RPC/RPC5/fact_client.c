/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "fact.h"


void
fact_prog_1(char *host,float a,float b)
{
	CLIENT *clnt;
	float  *result_1;
	intpair  fact_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, FACT_PROG, FACT_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	fact_1_arg.a=a;
	fact_1_arg.b=b;
	result_1 = fact_1(&fact_1_arg, clnt);
	if (result_1 == (float *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	else
	{
	 printf("Multiplication %f",*result_1);		
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;
	float a,b;
	int ch;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	do
        {
         system("clear");
	 printf("Enter number 1:");
	 scanf("%f",&a);
	 printf("Enter number 2:");
	 scanf("%f",&b);
	 fact_prog_1 (host,a,b);
         printf("Try again(1/0)::");
	 scanf("%d",&ch);
	
        }while(ch==1);

exit (0);
}