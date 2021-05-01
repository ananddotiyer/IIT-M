import yaml

f = open(r'D:\Official\GitHub\IITM_Journey\files\335982.yaml')

match = dict(yaml.load(f))

def next_over_ball(over, ball):
    if ball < 12:
        ball += 1
    elif ball == 12 and over <= 19:
        over += 1
        ball = 1
    else:
        over = 0
        ball = 1

    return (over, ball)
	
output_data = []

#match data
target_runs = 0
match_date = match['info']['dates'][0].strftime('%Y-%m-%d')
match_venue = match['info']['venue']

for each_inning in match['innings']:
    output_data.append({})  # a new record
    for inning in each_inning:
        output_data[-1]['date'] = match_date
        output_data[-1]['venue'] = match_venue
        output_data[-1]['innings'] = '1' if inning == '1st innings' else '2'
        output_data[-1]['target'] = '' if inning == '1st innings' else str(target_runs)
        output_data[-1]['team'] = each_inning[inning]['team']

        print(f'\n{inning}')
        deliveries = iter(each_inning[inning]['deliveries'])

        over = 0
        ball = 0
        num_wickets = 0
        num_deliveries = 0
        num_runs = 0
        
        delivery = next(deliveries)

        while over * ball < 12*19:
            # num_deliveries += 1
            over, ball = next_over_ball(over, ball)
            next_ball = f'{over}.{ball}'
            for info in delivery:
                if next_ball != str(info):
                    output_data[-1][next_ball] = ''
                    print(f'{next_ball} not bowled...')
                    if ball == 12:
                        print (f'd{over} = {num_deliveries}, w{over} = {num_wickets}, r{over} = {num_runs}')
                        output_data[-1][f'd{over}'] = num_deliveries
                        output_data[-1][f'w{over}'] = num_wickets
                        output_data[-1][f'r{over}'] = num_runs
                        if inning == '1st innings':
                            target_runs += num_runs

                        num_wickets = 0
                        num_deliveries = 0
                        num_runs = 0
                else:
                    num_deliveries += 1
                    print(f"Scored {delivery[info]['runs']['total']} in the {info} ball.")
                    output_data[-1][next_ball] = delivery[info]['runs']['total']
                    num_runs += delivery[info]['runs']['total']

                    try:
                        info = delivery[info]
                        info['wicket']
                        num_wickets += 1
                    except:
                        pass
                    try:
                        delivery = next(deliveries)  #move to the next delivery
                    except StopIteration:
                        break

print(output_data)

f.close()

import csv

with open(r'D:\Official\GitHub\IITM_Journey\files\matches.csv', 'w', newline='') as csvfile:
    fieldnames = output_data[0].keys()
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
    for each_record in output_data:
        writer.writerow(each_record)