/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "fact.h"

float *
fact_1_svc(intpair *argp, struct svc_req *rqstp)
{
	static float  result;
	float n1,fact;
	n1=argp->a;
	fact =n1*3.14/180;
	result = fact;
	/*
	 * insert server code here
	 */

	return &result;
}
