import logging
import random

logging.basicConfig(filename='game.log', level = logging.DEBUG)



CELLS = [(0,0),(0,1),(0,2),
	 (1,0),(1,1),(1,2),
	 (2,0),(2,1),(2,2)]

def get_locations():
	#monster = random
	monster = random.choice(CELLS)
	#door = random
	door = random.choice(CELLS)
	#start = random
	start = random.choice(CELLS)
	#if monster, door, or start are the same, do it again
	if monster == door or monster == start or start == door:
		return get_locations()
	#return monster,door,start
	return monster, door, start

def move_player(player,move):
	# Get the player's current location
	x, y = player
	# If move is LEFT, y -1
	if move == 'LEFT':
		y -= 1
	#If move is RIGHT, y+1
	elif move == 'RIGHT':
		y += 1
	#If move is UP, x-1
	elif move == 'UP':
		x -= 1
	#If move is DOWN, x + 1
	elif move == 'DOWN':
		x += 1
	return x,y

def get_moves(player):
	"""Based on the tuple of the player's position, return the list of acceptable moves


	"""
	moves = ['LEFT', 'RIGHT','UP','DOWN']
	#player = (x,y)
	if player[1] == 0:
		moves.remove('LEFT')
	if player[1] == 2:
		moves.remove('RIGHT')
	if player[0] == 0:
		moves.remove('UP')
	if player[0] == 2:
		moves.remove('DOWN')
	#if player's y is 0, remove left
	#if player's x is 0, remove up
	#if player's y is 2, remove right
	#if player's x is 2, remove down
	return moves

def draw_map(player, dict):
	# _ _ _
	#|_|_|_|
	print(' _ _ _')
	tile = '|{}'
	for idx, cell in enumerate(CELLS):
		if idx in [0,1,3,4,6,7]:
			if cell == player:
				print(tile.format('X'),end='')
			else:
				flag1 = True
				for value in dict.values():
					for item in value:
						if item == cell:
							print(tile.format('.'),end='')
							flag1 = False
				if flag1 == True:
					print(tile.format('_'),end='')
		else:
			if cell == player:
				print(tile.format('X|'))
			else:
				flag2 = True
				for value in dict.values():
						for item in value:
							if item == cell:
								print(tile.format(".|"))
								flag2 = False
				if flag2 == True:
					print(tile.format('_|'))


monster,door,player = get_locations()
logging.info('monster: {}; door: {}; player: {}'.format(monster,door,player))
list1 = []
print("Welcome to the dungeon!")
while True:
	moves = get_moves(player)
	print("You're currently in room {}".format(player)) # Fill in with player position
	list1.append(player)
	dict = {'location':list(list1)}
	draw_map(player, dict)

	print("You can move {}".format(moves)) # Fill in with available moves
	print("Enter QUIT to quit")

	move = input("> ")
	move = move.upper()

	if move == 'QUIT':
		break
	
	#If it's a good move, change the player's position
	if move in moves:
		player = move_player(player,move)
	else:
		print("** Walls are hard, stop walking into them! **")
		continue
	if player == door:
		print("You escaped!")
		break
	elif player == monster:
		print("You were eaten by the grue!")
		break
	
	#If it's a bad move, don't change anything
	
	#If the new player position is the door, they win!

	#If the new player position is the monster, they lose!

	#Otherwise, continue
