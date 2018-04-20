/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _FACT_H_RPCGEN
#define _FACT_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct intpair {
	float a;
};
typedef struct intpair intpair;

#define FACT_PROG 0x23451111
#define FACT_VERS 1

#if defined(__STDC__) || defined(__cplusplus)
#define FACT 1
extern  float * fact_1(intpair *, CLIENT *);
extern  float * fact_1_svc(intpair *, struct svc_req *);
extern int fact_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define FACT 1
extern  float * fact_1();
extern  float * fact_1_svc();
extern int fact_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_intpair (XDR *, intpair*);

#else /* K&R C */
extern bool_t xdr_intpair ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_FACT_H_RPCGEN */
