from questions import Add, Multiply

import datetime
import random

class Quiz:
	questions = []
	answers = []


	def __init__(self):
		# Generate 10 random questions with numbers from 1 to 10
		# Add these questions into self.questions
		question_type = (Add, Multiply)
		for _ in range(10):
			num1 = random.randint(1,10)
			num2 = random.randint(1,10)
			question = random.choice(question_type)(num1, num2)
			self.questions.append(question)

	def take_quiz(self):
		# Log the start time
		self.start_time = datetime.datetime.now()
		# Ask all the questions
		for question in self.questions:
			self.answers.append(self.ask(question))
		else:
			self.end_time = datetime.datetime.now()
		# Log if they got the question right
		# Log the end time
		# Show a summary
		return self.summary()
		
	
	def ask(self, question):
		correct = False
		# Log the start time
		question_start=datetime.datetime.now()
		# Capture the answer
		answer = input(question.text + ' = ')
		# Check the answer
		if answer == str(question.answer):
			correct = True
		# Log the end time
		question_end = datetime.datetime.now()
		# if the answer's right, send back True
		# Otherwise  send back False
		# Send back the elapsed time, too
		return correct, question_end - question_start

	def total_correct(self):
		# Return the total # of correct answers
		total = 0
		for answer in self.answers:
			if answer[0]:
				total += 1
		return total

	def summary(self):
		# Print how many you got right and the total # of questions
		# Print the total time for the quiz
		print("You got {} out of {} right.".format(self.total_correct(), len(self.questions)))
		print("It took you {} seconds total.".format((self.end_time-self.start_time).seconds))

Quiz().take_quiz()
