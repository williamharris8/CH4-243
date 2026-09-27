PHASE 1 - A queue is the right choice becuase its first in first out, so messages get processed in what order theyre sent. With a stack the newest message would go first so they'd come out 321 instead of 123.

PHASE 2 - Failed messages go to the back because otherwise they'd keep retrying and block those behind. But that spot is then lost so the message gets delayed even if sent first.

PHASE 3 - Starting at the back of main queue with zero retries, a poison message gets dequeued and fails each time it reaches the front. Retry count increases by one and it goes to the end of the line again.But after third failure the retry count hits max_retries so it goes into the DLQ.