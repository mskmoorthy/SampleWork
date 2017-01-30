from character import Character
from monster import Dragon,Goblin,Troll
import sys

class Game:
	def setup(self):
		self.player = Character()
		self.monsters = [
			Goblin(),
			Troll(),
			Dragon()
		]
		self.monster = self.get_next_monster()
	
	def get_next_monster(self):
		try:
			return self.monsters.pop(0)
		except IndexError:
			return None

	def monster_turn(self):
		# check to see if the monster attacks
		if self.monster.attack():
			print("{} is attacking!".format(self.monster))
			if input("Dodge? Y/N ").lower() == 'y':
				if self.player.dodge():
					print("You dodged the attack! ")
				else:
					print("You got hit anyway!")
					self.player.hit_points -= 1
			else:
				print("{} hit you for 1 point!".format(self.monster))
				self.player.hit_points -= 1
		else:
			print("{} isn't attacking this turn.".format(self.monster))
		# If so, tell the player
		# Check if the player wants to dodge
		# If so, see if the dodge is successful
		# If it is, move on
		# If it's not, remove one player hit point
		# If monster isn't attacking, tell that to the player too
		
	def player_turn(self):
		player_choice = input("[A]ttack, [R]est, [Q]uit? ").lower()
		if player_choice == 'a':
			print("You're attacking {}".format(self.monster))
			if self.player.attack():
				if self.monster.dodge():
					print("{} dodged your attack!".format(self.monster))
				else:
					if self.player.leveled_up():
						self.monster.hit_points -= 2
					else:
						self.monster.hit_points -= 1

					print("You hit {} with your {}".format(self.monster,self.player.weapon))
			else:
				print("You missed!")
		elif player_choice == 'r':
			self.player.rest()
		elif player_choice == 'q':
			sys.exit()
		else:
			self.player_turn()
		
		
		# Let the player attack, rest, or quit
		# If they attack:
			# See if the attack is successful
			# If so, see if the monster dodges
				#If dodged, print that
				#If not dodged, subtract the right num of hit points from the monster
			# If not a good attack, tell the player
		# If they rest:
			# Call the player.rest() method
		# If they quit, exit the game
		# If they pick anything else, re-run this method
	
	def cleanup(self):
		if self.monster.hit_points <= 0:
			self.player.experience += self.monster.experience
			print("You killed {}!".format(self.monster))
			self.monster = self.get_next_monster()


		# If the monster has no more hit points:
			#Up the player's experience
			# print a message
			# get a new monster

	def __init__(self):
		self.setup()

		while self.player.hit_points and (self.monster or self.monsters):
			print("\n"+"="*20)
			print(self.player)
			self.monster_turn()
			print('-'*20)
			self.player_turn()
			self.cleanup()
			print("\n"+"="*20)

		if self.player.hit_points:
			print("You win!")
		elif self.monsters or self.monster:
			print("You lose!")
		sys.exit()

Game()
