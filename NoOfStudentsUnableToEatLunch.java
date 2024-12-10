class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        // Count the number of students who want each type of sandwich
        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        // Serve sandwiches to students
        for (int sandwich : sandwiches) {
            // No student wants the circle sandwich on top of the stack
            if (sandwich == 0 && circleStudentCount == 0) {
                return squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if (sandwich == 1 && squareStudentCount == 0) {
                return circleStudentCount;
            }
            // Decrement the count of the served sandwich type
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        // Every student received a sandwich
        return 0;
    }

    
    public int countStudentsQueueStackApproach(int[] students, int[] sandwiches) {
        int ssSize = students.length;
        int lastServed = 0;

        // base corner case
        if (ssSize == 0 || (ssSize != sandwiches.length)){
        return 0;
        }
        Queue<Integer> studentsQueue = new LinkedList<>();;
        Stack<Integer> sandwichStack =  new Stack<>();;
        for(int i = 0; i<ssSize; i++)
        {
            studentsQueue.add(students[i]);
            sandwichStack.push(sandwiches[ssSize-i-1]);
        }

//Use the queues size since its getting updated frequently.
       while( !studentsQueue.isEmpty() && lastServed < studentsQueue.size() ) {
        if ( studentsQueue.peek() == sandwichStack.peek() )
        {
            studentsQueue.poll();
            sandwichStack.pop();
            lastServed = 0;
        } else {
            studentsQueue.offer(studentsQueue.poll());
            lastServed ++;
        }

       }

       return studentsQueue.size();
        
    }
}
