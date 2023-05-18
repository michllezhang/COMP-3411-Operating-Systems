#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main (int args, char *argv[])
{
	pid_t fork_return;
		pid_t pid;
    		pid=getpid();
    		fork_return = fork();

	if (fork_return==-1) {
		printf("\nError creating process " );
      			return 0;
	}
	if (fork_return==0) {
		printf("\n\nThe values are Child ID = %d, Parent ID=%d\n", getpid(), getppid());
		execl("/bin/cat", "cat", "-b", "-v", "-t", argv[1], NULL);
	}
		else {
	wait(NULL);
	printf("\nChild Completes " );
		printf("\nIn the Parent Process\n");
	printf("Child Id = %d, Parent ID = %d\n", getpid(), getppid());
		}
          return 0;
}
